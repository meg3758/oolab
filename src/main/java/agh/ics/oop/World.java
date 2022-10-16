package agh.ics.oop;

public class World {
    /*
    static void run(String s){
        System.out.println("zwierzak idzie do przodu");
        for (int i=0; i<s.length()-1;i++){
            System.out.print(s.charAt(i)+",");
        }
        int n=s.length()-1;
        System.out.println(s.charAt(n));
    }
    public static void main(String[] args) {
        System.out.println("system wystartował");
        run("fsfbbbddrlgfsfsf");
        System.out.println("system zakończył działanie");
    */
    /*
    static void run(String s){
        for (int i=0; i<s.length();i++){
            String letter = s.substring(i,i+1);
            String move = switch (letter) {
                case "f" -> "zwierzak idzie do przodu";
                case "b" -> "zwierzak idzie do tyłu";
                case "r" -> "zwierzak skręca w prawo";
                case "l" -> "zwierzak skręca w lewo";
                default -> "";
            };
            if (!move.equals("")){
            System.out.println(move);
            }
        }

    }
    public static void main(String[] args) {
        System.out.println("system wystartował");
        run("fsfbbbddrlgfsfsf");
        System.out.println("system zakończył działanie");
    }
    */
    /*
    static Direction command(String s){
        Direction move = switch (s) {
            case "f" -> FORWARD;
            case "b" -> BACKWARD;
            case "r" -> RIGHT;
            case "l" -> LEFT;
            default -> OTHER ;
        };
        return move;
    }
    static void run(Direction direction){
        String answer=switch (direction){
            case FORWARD -> "zwierzak idzie do przodu";
            case BACKWARD -> "zwierzak idzie do tyłu";
            case RIGHT -> "zwierzak skręca w prawo";
            case LEFT -> "zwierzak skręca w lewo";
            case OTHER -> "";
        };
        if(!answer.equals("")){
            System.out.println(answer);
        }
    }
    public static void main(String[] args){
        System.out.println("system wystartował");
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        int[] arr = new int[s.length()];
        for (int i=0; i<s.length();i++){
            String letter = s.substring(i,i+1);
            Direction movement= command(letter);
            run(movement);}
        System.out.println("system zakończył działanie");
    }
     */
    /* tym razem lepiej zrobione (metoda run przyjmująca tablicę stringów)
    static void run(String[] letters){
        for (int i=0;i<letters.length;i++){
            switch (letters[i]){
                case "f":
                    System.out.println("zwierzak idzie do przodu");
                    break;
                case "b":
                    System.out.println("zwierzak idzie do tyłu");
                    break;
                case "r":
                    System.out.println("zwierzak skręcił w prawo");
                    break;
                case "l":
                    System.out.println("zwierzak skręcił w lewo");
                    break;
                default:
                    break;
            }
        }
    }

     */

    public static void commands(String[] letters, Direction[] arr){
        int count=0;
        for (int i=0;i<letters.length;i++){
            switch(letters[i]){
                case "f":
                    arr[count]=Direction.FORWARD;
                    count++;
                    break;
                case "b":
                    arr[count]=Direction.BACKWARD;
                    count++;
                    break;
                case "r":
                    arr[count]=Direction.RIGHT;
                    count++;
                    break;
                case "l":
                    arr[count]=Direction.LEFT;
                    count++;
                    break;
                default:
                    break;

            }
        }
    }
    public static void run(Direction[] arr){
        for (int i=0;i<arr.length;i++){
            String movement = switch(arr[i]){
                case FORWARD -> "zwierzak idzie do przodu";
                case BACKWARD -> "zwierzak idzie do tyłu";
                case RIGHT -> "zwierzak skręca w prawo";
                case LEFT -> "zwierzak skręca w lewo";
                default-> "";
            };
            System.out.println(movement);
        }
    }

    public static void main(String[] args) {
        //String[] letters= {"i","f","d","r"};
        System.out.println("system wystartował");
        int counter = 0;
        Direction[] arr = new Direction[0];
        for (int i = 0; i < args.length; i++) {
            if (args[i].matches("f|b|r|l")) {
                counter++;
            }
            arr = new Direction[counter];
        }
        commands(args, arr);
        run(arr);
        //run(letters);
        System.out.println("system zakończył działanie");
    }
}

