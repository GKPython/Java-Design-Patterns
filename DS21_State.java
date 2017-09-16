//Context
class Context {

    private Weather weather;

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Weather getWeather() {
        return this.weather;
    }

    public String weatherMessage() {
        return weather.getWeather();
    }
}
//state
interface Weather {

    String getWeather();
}


//Concrete*tatesubclasses 

class Rain implements Weather {

    public String getWeather() {
        return "下雨";
    }
}

class Sunshine implements Weather {

    public String getWeather() {
        return "阳光";
    }
}


class DS21_State{

    public static void main(String[] args) {
        Context ctx1 = new Context();
        ctx1.setWeather(new Sunshine());
        System.out.println(ctx1.weatherMessage());

        System.out.println("===============");

        Context ctx2 = new Context();
        ctx2.setWeather(new Rain());
        System.out.println(ctx2.weatherMessage());
    }
}
