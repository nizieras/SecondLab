package org.example;

public class Cup extends Subject{
    private int volume;
    private String content;
    public Cup(int weight, int volume, String content)
    {
        super(weight);
        this.volume =volume;
        this.content = content;
    }
    public void setVolume(int newVolume)
    {
        this.volume = newVolume;
    }
    public void setContent(String newContent)
    {
        this.content = newContent;
    }
    public int getVolume()
    {
        return this.volume;
    }
    public String getContent()
    {
        return this.content;
    }
    public void fillSugar(Sugar sugar)
    {
        this.setContent(this.getContent() + " сахар ");
        this.setWeight(this.getWeight()+ sugar.getWeight());
    }
    public void fillCoffee(Coffee coffee)
    {
        this.setContent(this.getContent() + " кофе ");
        this.setWeight(this.getWeight()+coffee.getWeight());
    }
    public void fillWater(Kettle kettle)
    {
        this.setContent(this.getContent() + " вода ");
        if(this.getVolume()< kettle.getVolume())
        {
            kettle.setVolume(kettle.getVolume()-this.getVolume());
        }
        this.setWeight(this.getWeight()+ this.getVolume());
    }
}
