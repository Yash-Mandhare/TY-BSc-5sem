package SY;

public class SYMarks {
    private double computerTotal;
    private double mathsTotal;
    private double electronicsTotal;

    public SYMarks(double computerTotal, double mathsTotal, double electronicsTotal) {
        this.computerTotal = computerTotal;
        this.mathsTotal = mathsTotal;
        this.electronicsTotal = electronicsTotal;
    }

    public double getComputerTotal() {
        return computerTotal;
    }

    public double getMathsTotal() {
        return mathsTotal;
    }

    public double getElectronicsTotal() {
        return electronicsTotal;
    }
}
