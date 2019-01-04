package runemonitor;

import java.util.ArrayList;
import javafx.util.Pair;

public class Rune {

    // FIELD VARIABLES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private RuneSet set;
    private int slot, grade, level;
    private Pair<StatType, Integer> main, prefix;
    private ArrayList<Pair<StatType, Integer>> substats;

    // CONSTRUCTOR ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Rune(RuneSet set, int slot, int grade, int level, 
            Pair<StatType, Integer> main, Pair<StatType, Integer> prefix, 
            ArrayList<Pair<StatType, Integer>> substats) {
        this.set = set;
        this.slot = slot;
        this.grade = grade;
        this.level = level;
        this.main = main;
        this.prefix = prefix;
        this.substats = substats;
        // TODO: add a criteria to check the genuinity of the rune.
        // TODO: is slot between 1-6
        // TODO: is grade(stars) between 1-6
        // TODO: is level(+) between 0-15
        // TODO: are the stat types unique between the main, prefix and the substats
    }

    // ACCESSORS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public RuneSet getRuneSet() { return this.set; }
    public int getSlotNo() { return this.slot; }
    public int getGrade()  { return this.grade; }
    public int getLevel() { return this.level; }
    // TODO: add accessor for the main stat
    // TODO: add accessor for the prefix stat
    // TODO: add accessor for the substats

    // MUTATORS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    // INTERNAL CLASSES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public enum Rarity {
        WHITE("Normal"), GREEN("Magic"), BLUE("Rare"), PURPLE("Hero"), 
        ORANGE("Legendary");

        private String rarity;

        private Rarity(String rarity) {
            this.rarity = rarity;
        }

        @Override
        public String toString() { return this.rarity; }
    }

    public enum StatType {
        HP_FLAT("HP (+)", 300, 375), HP_PERC("HP %", 7, 8),
        ATK_FLAT("ATK (+)", 15, 20), ATK_PERC("ATK %", 7, 8),
        DEF_FLAT("DEF (+)", 15, 20), DEF_PERC("DEF %", 7, 8),
        SPD("SPD (+)", 5, 6),
        CRI_R("CRI Rate %", 5, 6), CRI_D("CRI Dmg %", 5, 7),
        RES("RES %", 7, 8), ACC("ACC %", 7, 8);

        private String type;
        private int fiveMax, sixMax;

        private StatType(String type, int five, int six) {
            this.type = type;
            this.fiveMax = five;
            this.sixMax = six;
        }

        public int getFiveMax() { return this.fiveMax; }
        public int getSixMax() { return this.sixMax; }

        @Override
        public String toString() {
            return this.type;
        }
    }

    public enum RuneSet {
        ENERGY("Energy", "HP +15%"),
        FATEL("Fatel", "Attack Power +35%"),
        BLADE("Blade", "Critical Rate +12%"),
        SWIFT("Swift", "Attack Speed +25%"),
        FOCUS("Focus", "Accuracy +20%"),
        GUARD("Guard", "Defense +15%"),
        ENDURE("Endure", "Resistance +20%"),
        SHIELD("Shield", "Ally Shield 3 turns (15% of HP)"),
        REVENGE("Revenge", "Counterattack +15%"),
        WILL("Will", "Immunity +1 turn"),
        NEMESIS("Nemesis", "ATK Gauge +4% (for ever 7% HP lost)"),
        VAMPIRE("Vampire", "Life Drain +35%"),
        DESTROY("Destroy", "Enemy MAX HP -4% (30% of DMG dealt)"),
        DESPAIR("Despair", "Stun Rate +25%"),
        VIOLENT("Violent", "Get Extra Turn +22%"),
        RAGE("Rage", "Critical Damange +40%"),
        FIGHT("Fight", "Allies' ATK +8%"),
        DETERMINATION("Determination", "Allies' DEF +8%"),
        ENHANCE("Enhance", "Allies' HP +8%"),
        ACCURACY("Accuracy", "Allies' ACC +10%"),
        TOLERANCE("Tolerance", "Allies' RES +10%");

        private String set, description;

        private RuneSet(String set, String description) {
            this.set = set;
            this.description = description;
        }

        public String getSet() { return this.set; }
        public String getDescription() { return this.description; }

        @Override
        public String toString() {
            return this.set + ": " + this.description + ".";
        }
    }
}
