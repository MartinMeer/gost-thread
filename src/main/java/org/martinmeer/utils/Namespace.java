package org.martinmeer.utils;

public enum Namespace {
    PITCHES(),
    DEVIATIONS("", ""),
    TOLERANCES_d("", ""),
    PITCH_DIAM_TOLERANCE("", ""),
    NOM_DIAM_TOLERANCE("nom_diam_tolerances", "nom_diam_tolerance"),
    PITCH("pitches", "pitch"),
    MULTISTART_TREAD(),
    TOLERANCE_ZONE(),
    DEVIATION("basic_deviation", "deviation"),
    DIRECTION(),
    NOMINAL_SIZE("nom_diams", "nom_diam"),
    PITCH_DIAMETER(),
    DB_QUERY(),
    DB_ALIAS(),
    NOM_DIAMETER(),
    PARAMETER();

    Namespace(String dbTable, String dbColumn) {
        this.dbTable = dbTable;
        this.dbColumn = dbColumn;
    }

    Namespace() {
    }

    public String getdbTable() {
        return dbTable;
    }

    public String getDbColumn() {
        return dbColumn;
    }
    public String dbTable;
    public String dbColumn;
}
