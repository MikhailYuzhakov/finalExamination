import java.util.ArrayList;
import java.util.Scanner;

public class AnimalsRegistry {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Menu menu = new Menu();
        System.out.print("\033[H\033[J");
        while (!(menu.viewMenu().equals("Выйти из программы"))) {
            System.out.println(menu.viewMenu());
            System.out.println("< - предыдущий  > - следующий   y - выполнить");
            if (in.next().equals(">")) {
                System.out.print("\033[H\033[J");
                menu.nextPos();
            } else if (in.next().equals("<")) {
                System.out.print("\033[H\033[J");
                menu.prevPos();
            } else if (in.next().equals("y")) {
                menu.executeCommand();
            }
        }
        in.close();
    }
}

class Menu {
    ArrayList<String> menu = new ArrayList<>();
    ArrayList<Animals> animalsList = new ArrayList<>();
    
    Integer position = 0;
    public Menu() {
        menu.add("Создать животное");
        menu.add("Показать всех животных");
        menu.add("Получить список команд животного");
        menu.add("Получить информацию о животном");
        menu.add("Добавить команду");
        menu.add("Выйти из программы");
    }

    public String viewMenu() {
        return menu.get(position);
    }

    public void nextPos() {
        if (position + 1 > 5) {
            position = 0;
        } else {
            position = position + 1;
        }   
    }   
    
    public void prevPos() {
        if (position - 1 < 0) {
            position = 4;
        } else {
            position = position - 1;
        }
    }

    public void executeCommand() {
        switch (position) {
            case 0:
                try (Counter counter = new Counter();) {
                    Scanner in = new Scanner(System.in);
                    System.out.print("\033[H\033[J");
                    System.out.println("Введите тип животного (camel, cat, dog, horse, humster, donkey):");
                    String type = in.next();
                    System.out.println("Введите имя животного:");
                    String name = in.next();
                    System.out.println("Введите возраст:");
                    Integer age = in.nextInt();
    
                    if (type.equals("camel"))
                            animalsList.add(new Camels(name, age));
                    if (type.equals("cat"))
                            System.out.println("Создаем котика");
                            animalsList.add(new Cats(name, age));
                    if (type.equals("dog"))
                            animalsList.add(new Dogs(name, age));
                    if (type.equals("horse"))
                            animalsList.add(new Horses(name, age));
                    if (type.equals("humster"))
                            animalsList.add(new Humsters(name, age));
                    if (type.equals("donkey"))
                            animalsList.add(new Donkeys(name, age));
                    counter.increment();
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            case 1:
                System.out.print("\033[H\033[J");
                System.out.println(animalsList);
                break;
            case 2:
                Scanner in = new Scanner(System.in);
                System.out.print("\033[H\033[J");
                System.out.println("Введите имя животного для вывода его команд");
                String name = in.next();
                for (int i = 0; i < animalsList.size(); i++) {
                    if (animalsList.get(i).getName().equals(name)) {
                        Animals animal = animalsList.get(i);
                        System.out.println("Список команд:" + animal.getCommandList());
                    }
                }
                break;
            case 3:
                in = new Scanner(System.in);
                System.out.print("\033[H\033[J");
                System.out.println("Введите имя животного:");
                name = in.next();

                for (int i = 0; i < animalsList.size(); i++) {
                    if (animalsList.get(i).getName().equals(name)) {
                        Animals animal = animalsList.get(i);
                        System.out.println(animal.getInfo());   
                    }
                }
                break;
            case 4:
                in = new Scanner(System.in);
                System.out.print("\033[H\033[J");
                System.out.println("Введите имя животного:");
                name = in.next();
                System.out.println("Введите команду");
                String cmd = in.next();

                for (int i = 0; i < animalsList.size(); i++) {
                    if (animalsList.get(i).getName().equals(name)) {
                        Animals animal = animalsList.get(i);
                        animal.addCmd(cmd);
                    }
                }
                System.out.println("Команда добавлена");
                break;
        }
    }
}

class Counter implements AutoCloseable {
    private int counter;
    public Counter() {
        counter = 0;
    }

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int get() {
        return counter;
    }

    @Override
    public void close() throws Exception {
        System.out.println("try with resources");
    }
}