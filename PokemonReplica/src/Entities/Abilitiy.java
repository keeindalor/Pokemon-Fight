package Entities;

public class Abilitiy {

    private int damage = 0;
    private int cd = 0;
    private int remainingCd = 0;
    private boolean stun = false;
    private boolean dodge = false;

    private Abilitiy(AbilityBuilder builder) {
        this.damage = builder.dmg;
        this.cd = builder.cd;
        this.stun = builder.stun;
        this.dodge = builder.dodge;
    }
    public int getRemainingCd() {
        return remainingCd;
    }
    public void setRemainingCd(int remainingCd) {
        this.remainingCd = remainingCd;
    }

    public int getDamage() {
        return damage;
    }

    public int getCd() {
        return cd;
    }

    public boolean isStun() {
        return stun;
    }

    public boolean isDodge() {
        return dodge;
    }

    public boolean isOnCd() {
        return remainingCd != 0;
    }
    public void decreaseCd() {
        if (remainingCd > 0)
            remainingCd--;
    }
    public static class AbilityBuilder {
        private int dmg, cd;
        private boolean stun, dodge;
        public AbilityBuilder dmg (int dmg) {
            this.dmg = dmg;
            return this;
        }
        public AbilityBuilder cd (int cd){
            this.cd = cd;
            return this;
        }
        public AbilityBuilder stun (boolean stun) {
            this.stun = stun;
            return this;
        }
        public AbilityBuilder dodge (boolean dodge) {
            this.dodge = dodge;
            return this;
        }
        public Abilitiy build() {
            Abilitiy abilitiy = new Abilitiy(this);
            return abilitiy;
        }

    }
}
