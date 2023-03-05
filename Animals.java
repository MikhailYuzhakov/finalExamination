import java.util.ArrayList;

public class Animals {
    private String name;
    Integer age;
    String type;
    ArrayList<String> commandList;

    protected Animals(String name, Integer age) {
        this.name = name;
        this.age = age;
        commandList = new ArrayList<>();
    }

    public void addCmd(String cmd) {
        commandList.add(cmd);
    }

    public String getCommandList() {
        StringBuilder sb = new StringBuilder();
        for (String string : commandList) {
            sb.append(string + ",");
        }
        return sb.toString();
    } 

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return String.format("Имя: %s; Возраст:%d; Список команд:%s", name, age, getCommandList());
    }

    @Override
    public String toString() {
        String output = String.format("\nИмя: %s; Возраст:%d", name, age);
        return output;
    }
}
