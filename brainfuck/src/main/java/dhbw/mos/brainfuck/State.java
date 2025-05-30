package dhbw.mos.brainfuck;

public class State {
    private int[] memory = new int[1024];
    private int pointer = 0;

    public int[] getMemory() {
        return memory;
    }

    public void setMemory(int[] memory) {
        this.memory = memory;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }
}
