public class ChemicalBath {
   private String id;
   private double currentVolume;
   private double currentConcentration;

    public ChemicalBath(String id, double currentVolume, double currentConcentration) {
        this.id = id;
        this.currentVolume = currentVolume;
        this.currentConcentration = currentConcentration;
    }


    public double calculateRefillLiters (double targetConcentration, double currentConcentration, double currentVolume) {
       if (targetConcentration <= currentConcentration) {
           return 0;
       }

       if (targetConcentration > 1 || targetConcentration <= 0) {
           throw new IllegalArgumentException("Target concentration must be between 0 and 1");
       }

       return (targetConcentration - currentConcentration) * currentVolume / (1-targetConcentration);
    }

    public String getId() {
        return id;
    }

    public double getCurrentVolume() {
        return currentVolume;
    }

    public double getCurrentConcentration() {
        return currentConcentration;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCurrentVolume(double currentVolume) {
        this.currentVolume = currentVolume;
    }

    public void setCurrentConcentration(double currentConcentration) {
        this.currentConcentration = currentConcentration;
    }
}


