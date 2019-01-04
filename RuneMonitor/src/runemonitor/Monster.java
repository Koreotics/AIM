package runemonitor;

public class Monster {

//    public static void main(String[] args) {
//        Monster monster = new Monster("Taor", "Chimera", 
//                Monster.Element.WATER);
//        System.out.println(monster.toString());
//    }
    
    // FIELD VARIABLES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private String name, monster;
    private Element element;
    // TODO: add variable to store six runes

    // CONSTRUCTORS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Monster(String name, String monster, Element element) {
        this.name = name;
        this.monster = monster;
        this.element = element;
        // TODO: add code to include runes.
    }

    // ACCESSORS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String getName() { return this.name; }
    public String getMonster() { return this.monster; }
    public Element getElement() { return this.element; }
    // TODO: add accessor for getting all six runes from the element.
    // TODO: add accessor for getting a single slotted rune.

    // MUTATORS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void setName(String name) { this.name = name; }
    public void setMonster(String monster) { this.monster = monster; }
    public void setElement(Element element) { this.element = element; }
    // TODO: add mutator that for setting all runes of the monster
    // TODO: add mutator that for setting a single rune

    @Override
    public String toString() {
    
        StringBuilder builder = new StringBuilder();
        builder.append(this.name);
        builder.append(": ");
        builder.append(this.element.toString());
        builder.append(" ");
        builder.append(this.monster);
        builder.append(".");
        return builder.toString();
    }

    // INTERNAL CLASSES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public enum Element {
        FIRE("Fire"), WATER("Water"), WIND("Wind"), LIGHT("Light"), 
        DARK("Dark");

        private String element;

        private Element(String element) {
            this.element = element;
        }

        @Override
        public String toString() { return this.element; }
    }
}
