package runemonitor;

public class Stat {
    
//    public static void main(String[] args) {
//        Stat stat = new Stat(5, Stat.Type.SPD, 2);
//        System.out.println(stat.toString());
//    }
    
    // FIELD VARIABLES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private Type type;
    private int value;
    
    // CONSTRUCTORS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Stat(int grade, Type type, int value) {
        this.type = type;
        this.setValue(grade, value);
        
    }
    
    // ACCESSORS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Type getType() { return this.type; }
    public int getValue() { return this.value; }
    
    // MUTATORS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void setValue(int grade, int value) { 
        if(grade == 5 && value >= type.getFiveMin() 
                && value <= (type.getFiveMax() * 5)) {
            this.value = value;
        } else if (grade == 6 && value >= type.getSixMin() 
                && value <= (type.getSixMax() * 5)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException(value + " isn't within the "
                    + "boundries of " + type.toString() + ".");
        }
    }
    
    // UTILITIES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Override
    public String toString() { 
        return type.toString() + ": " + value;
    }
    
    // INTERNAL CLASSES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public enum Type {
        HP_FLAT("HP(+)", 90, 300, 135, 375), HP_PERC("HP%", 4, 7, 5, 8),
        ATK_FLAT("ATK(+)", 8, 15, 10, 20), ATK_PERC("ATK%", 4, 7, 5, 8),
        DEF_FLAT("DEF(+)", 8, 15, 10, 20), DEF_PERC("DEF%", 4, 7, 5, 8),
        SPD("SPD(+)", 3, 5, 4, 6),
        CRI_R("CRI Rate%", 3, 5, 4, 6), CRI_D("CRI Dmg%", 3, 5, 4, 7),
        RES("RES%", 3, 7, 4, 8), ACC("ACC%", 3, 7, 4, 8);

        private String type;
        private int fiveMin, fiveMax, sixMin, sixMax;

        private Type(String type, int fiveMin, int fiveMax, int sixMin, 
                int sixMax) {
            this.type = type;
            this.fiveMin = fiveMin;
            this.fiveMax = fiveMax;
            this.sixMin = sixMin;
            this.sixMax = sixMax;
        }

        public int getFiveMin() { return this.fiveMin; }
        public int getFiveMax() { return this.fiveMax; }
        public int getSixMin() { return this.sixMin; }
        public int getSixMax() { return this.sixMax; }

        @Override
        public String toString() {
            return this.type;
        }
    }
}
