package domain;

import java.util.ArrayList;
import java.util.List;

import logger.Log;
import dao.Dao;
import dao.DaoException;
import dao.DaoFactory;
import dao.WordDao;
import dao.mysql.DaoFactoryImpl;
import dao.mysql.Messages;

public class Main {

    public static void main(String[] args) {

        DaoFactory daoFactory = null;
        try {
            daoFactory = new DaoFactoryImpl();

        } catch (DaoException e) {
            Log.error(Messages.CREATE_DAO_FACTORY_ERROR + e);
            System.out.println(Messages.CREATE_DAO_FACTORY_ERROR + e);
        }

        List<Word> words = new ArrayList<Word>();
        Dao<Word> wordDao = daoFactory.createDao(WordDao.class);
        try {
            words = wordDao.getAll();
        } catch (DaoException e) {
            System.out.println("Get all from database error: " + e);
        }

        showAll(wordDao);

        Word word = words.get(5);
        word.setCorrect(1);
        word.setTotal(2);

        try {
            wordDao.update(word);
        } catch (DaoException e) {
            System.out.println("Update dao error: " + e);
        }

        showAll(wordDao);

        try {
            wordDao.delete(words.size());
        } catch (DaoException e) {
            System.out.println("Delete dao error: " + e);
        }

        showAll(wordDao);
        
        word = new Word("bitch","сучара");
        
        try {
            wordDao.create(word);
        } catch (DaoException e) {
            System.out.println("Create dao error: " + e);
        }
        
        showAll(wordDao);

    }

    private static void showAll(Dao<Word> wordDao) {
        List<Word> words = null;
        try {
            words = wordDao.getAll();
        } catch (DaoException e) {
            System.out.println("Get all from database error: " + e);
        }

        for (Word w : words) {
            System.out.println(w.getId() + "_" + w.getEng() + "_" + w.getRus() + "_" + w.getCorrect() + "_"
                    + w.getTotal());
        }
        
        System.out.println("------------");
    }
}
