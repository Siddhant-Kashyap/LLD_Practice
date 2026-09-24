package BuilderPattern;

public class Car {
    private String carNumber;
    private String Transmission;
    private String gear;
    private String color;
    private String model;
    private String tyreColor;

    private Car (CarBuilder carBuilder){
        this.carNumber= carBuilder.carNumber;
        this.Transmission=carBuilder.Transmission;
        this.gear =carBuilder.gear;
        this.color= carBuilder.color;
        this.model = carBuilder.model;
        this.tyreColor = carBuilder.tyreColor;
    }


    public static class CarBuilder{
        private String carNumber;
        private String Transmission;
        private String gear;
        private String color;
        private String model;
        private String tyreColor;

        public CarBuilder(String carNumber,String Transmission){
            this.carNumber=carNumber;
            this.Transmission=Transmission;
        }

        public CarBuilder setCarNumber(String carNumber) {
            this.carNumber =carNumber ;
            return this;
        }
        public CarBuilder Color(String color) {
            this.color = color;
            return this;
        }
        public CarBuilder setGear(String gear) {
            this.gear = gear;
            return this;
        }
        public CarBuilder setColor(String color){
            this.color = color;
            return this;
        }
        public CarBuilder setModel(String model){
            this.model= model;
            return this;
        }
        public CarBuilder setTyreColor(String tColor){
            this.tyreColor=tColor;
            return this;
        }
        public Car build(){
            return new Car(this);
        }
    }
}
