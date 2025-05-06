package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.Exceptions.DuplicateNameException;
import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

	public static void main(String[] args) {
		
		List <String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        List <String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();
        List <String> lastNames = null;
        try{
            lastNames = CSVReader_Writer.getLastNames();
        } catch (IOException e) {
            System.out.println("Error from CSVReader_Writer.getLastNames: " + e.getMessage());
        }

        NameService nameService = new NameService(maleFirstNames, femaleFirstNames,lastNames);

        try {
            nameService.addFemaleFirstName("Alice");
        } catch (DuplicateNameException e) {
            handleDuplicateError(e);
        }
        try {
            nameService.addMaleFirstName("William");
        } catch (DuplicateNameException e) {
            handleDuplicateError(e);
        }
        try {
            nameService.addLastName("Andersson");
        } catch (DuplicateNameException e) {
            handleDuplicateError(e);
        }

        try {
            nameService.addFemaleFirstName("Amanda");
            nameService.addMaleFirstName("Dennis");
            nameService.addLastName("Olsen");
        } catch (DuplicateNameException e) {
            handleDuplicateError(e);
        }

        Person test = nameService.getNewRandomPerson();
        System.out.println(test);

	}

    public static void handleDuplicateError(DuplicateNameException e){
        System.out.println(e.getMessage() + e.getName());
    }

}
