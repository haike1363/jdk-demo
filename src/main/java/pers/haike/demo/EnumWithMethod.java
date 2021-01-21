package pers.haike.demo;

public enum EnumWithMethod implements Operation{
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return 0;
        }
    };
    private final String symbol;
    EnumWithMethod(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
