package org.example;



public class Coffee extends Subject{
    private String taste;
    public Coffee(int weight, String taste)
    {
        super(weight);
        this.taste = taste;
    }
    public void setTaste(String newTaste)
    {
        this.taste = newTaste;
    }
    public String getTaste()
    {
        return this.taste;
    }
    public void pour(Cup cup) throws InterruptedException {

        cup.fillCoffee(this);
        this.setWeight(0);
        this.setTaste("отсутствует");
        //TimeUnit.SECONDS.sleep(10);
    }
}
