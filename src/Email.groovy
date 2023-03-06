class Mail {
    String from, to, body;

    def from(String fromNumber) {}

    def to(String toNumber) {}

    def body(String body) {}

    def send() {
        print "$from $to $body"
    }

    def static send(Closure block) {
        Mail m = new Mail()
        block.delegate = m
        block()
        m.send()
    }
}

println Mail.send {
    from '555-432-1234'
    to '555-678-4321'
    body 'Hey there'
}
