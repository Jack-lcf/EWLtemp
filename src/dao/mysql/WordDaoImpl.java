package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoException;
import dao.WordDao;
import domain.Word;

public class WordDaoImpl extends AbstractJDBCDao<Word> implements WordDao {

    public WordDaoImpl(ConnectionFactory cf) {
        super(cf);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT `id`, `eng`, `ru`,`correct`,`total` FROM `dictionary`;";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES (?,?,?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE `dictionary` SET `eng`=?,`ru`=?,`correct`=?,`total`=? WHERE `id`=?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM `dictionary` WHERE `id` = ?";
    }

    @Override
    protected List<Word> parseResultSet(ResultSet rs) throws DaoException {
        List<Word> result = new ArrayList<Word>();
        try {
            while (rs.next()) {
                Word word = new Word();
                word.setId(rs.getInt("id"));
                word.setEng(rs.getString("eng"));
                word.setRus(rs.getString("ru"));
                word.setCorrect(rs.getInt("correct"));
                word.setTotal(rs.getInt("total"));
                result.add(word);
            }
            return result;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Word object) throws DaoException {
        try {
            statement.setString(1, object.getEng());
            statement.setString(2, object.getRus());
            statement.setInt(3, object.getCorrect());
            statement.setInt(4, object.getTotal());
            statement.setInt(5, object.getId());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Word object) throws DaoException {
        try {
            statement.setString(1, object.getEng());
            statement.setString(2, object.getRus());
            statement.setInt(3, object.getCorrect());
            statement.setInt(4, object.getTotal());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

}
