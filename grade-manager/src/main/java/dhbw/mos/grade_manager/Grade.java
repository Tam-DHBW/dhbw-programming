package dhbw.mos.grade_manager;

public record Grade(Module module, float score) {
    public boolean passed() {
        return score <= 4.0;
    }
}
