

trait Voertuig {
    abstract def speed()
}

class CarTest implements Voertuig {
    def mark
   // Integer speed = 0

    def accalerate(delta) {
        speed += delta
    }



    @Override
    public String toString() {
        return "Car{" +
                "mark=" + mark +
                ", speed=" + speed +
                '}';
    }

    @Override
    def speed() {
        return null
    }
}

def car = new CarTest()
car.accalerate(5)

println car


class Semi extends CarTest {

    @Override
    def accalerate(Object delta) {
        speed += 2

    }
}


