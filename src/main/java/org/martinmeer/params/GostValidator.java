package org.martinmeer.params;

import org.martinmeer.jbdc.CheckDAO;
import org.martinmeer.utils.Namespace;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class GostValidator {


    public boolean validate(Map<Namespace, String> inputMap) throws SQLException, IOException {
        var actualMap = generateActualMap(inputMap);
        Map<Namespace, String> mapToCheck = generateMapToCheck(actualMap);
        Predicate<String> predicate = String::isEmpty;
        return mapToCheck.values().stream().anyMatch(predicate);
    }

    private Map<Namespace, String> generateMapToCheck(Map<Namespace, String> actualMap) throws SQLException, IOException {
        Map<Namespace, String> checkedMap = new HashMap<>();
        var kvset = actualMap.entrySet();
        String dbAnswer;
        String dbTable;
        String dbColumn;
        for (var kv : kvset) {
            dbTable = kv.getKey().getdbTable();
            dbColumn = kv.getKey().getDbColumn();
            CheckDAO checkDAO = new CheckDAO();
            String query = (queryGen(dbTable, dbColumn));
            String parameter = kv.getValue();
            Map<Namespace, String> sql = Map.of(
                    Namespace.DB_QUERY, query,
                    Namespace.PARAMETER, parameter,
                    Namespace.DB_ALIAS, dbColumn
            );
            dbAnswer = checkDAO.getValue(sql);
            checkedMap.put(kv.getKey(), dbAnswer);
        }
        return checkedMap;

    }
    private String queryGen(String dbTable, String dbColumn) {

        return "SELECT "
                + dbColumn
                + " FROM "
                + dbTable
                + " WHERE "
                + dbColumn
                + " = ?;";
    }
/*! add filter!!*/
    private Map<Namespace, String> generateActualMap(Map<Namespace, String> inputMap) {
        Map<Namespace, String> actualMap = new HashMap<>();
        inputMap.entrySet().stream()
                .forEach(e -> {
                    if (e.getValue() != null) {
                        actualMap.put(e.getKey(), e.getValue());
                    }
                    actualMap.remove(Namespace.MULTISTART_TREAD);
                    actualMap.remove(Namespace.DIRECTION);
                    actualMap.remove(Namespace.TOLERANCE_ZONE);
                });

        return actualMap;
    }
}
