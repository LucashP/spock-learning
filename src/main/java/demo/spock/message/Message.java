package demo.spock.message;

public class Message {

    private String content;

    public Message() {
        content = "default message";
    }

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
