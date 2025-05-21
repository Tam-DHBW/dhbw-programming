package dhbw.mos.grade_manager;

public enum Season {
    SUMMER,
    WINTER;

    public SemesterIdentifier ofYear(int year) {
        return new SemesterIdentifier(year, this);
    }
}
