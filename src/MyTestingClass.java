class MyTestingClass {
    private int key;

    public MyTestingClass(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        return key;
    }
}