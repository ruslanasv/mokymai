# Užduotis

Parašykite programą, kuri realizuoja klasę `Scheduler`. Ši klasė yra atsakinga už tam tikros užduoties
periodinį vykdymą. 

Šios klasės konstruktorius apibrėžtas tokiu būdu:

```
Scheduler(TimeUnit timeUnit, long time, Runnable runnable) {...}
```

Jis priima tris argumentus:

- `TimeUnit timeUnit` - laiko vienetas (pvz. sekundė, minutė, valanda ir t.t.)
- `long time` - laikas (jo vienetas apibrėžtas pirmuoju parametru), nusakantis kokiu dažnumu reikia vykdyti užduotį.
- `Runnable runnable` - užduotis, kuri bus vykdoma periodiškai.

Periodinis užduočių vykdymas prasideda iškvietus metodą `Scheduler.start`.
Periodinis užduočių vykdymas nutraukiamas iškvietus metodą `Scheduler.stop`.

Papildomai:

Klasė `TimeUnit` turi metodą `sleep`, kurio veikimas identiškas metodo `Thread.sleep` kvietimui, tačiau papildomai
jis konvertuoja laiko vienetą į milisekundes.

Panaudojimo pavyzdys:

```
package multithreading;

import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws Exception {
        Scheduler scheduler = new Scheduler(TimeUnit.SECONDS, 1, () -> System.out.println("Tick"));
        scheduler.start();

        Thread.sleep(60_000);
        scheduler.stop();
    }

}
```

Programa išves į konsolę tekstą "Tick" kas sekundę, o po 60 sekundžių baigs darbą.

# Sprendimas

Sprendimas pateiktas kataloge `src/main/java`.