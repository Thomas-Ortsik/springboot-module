package academy.everyonecodes.amazinghelloworld.hello;

import org.springframework.stereotype.Service;

@Service
public class AmazingHelloWorld {
    private final World world;
    private final Hello hello;

    public AmazingHelloWorld(Hello hello, World world) {
        this.hello = hello;
        this.world = world;
    }

    public String get(){
        return hello.get() + " " + world.get();
    }
}
