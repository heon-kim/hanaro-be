package chap9_Collection;

import java.util.HashSet;
import java.util.Set;

public class p145_1 {
    static class Person{
        String name;
        int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public int getAge(){
            return age;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setAge(int age) {
            this.age = age;
        }

        public boolean equals(Object obj){
            if (obj instanceof Person){
                Person person = (Person) obj;
                return person.getName().equals(name)&&person.getAge()==age;
            }
            else{ return false; }
        }
        public int hashCode() {
            return name!=null ? name.hashCode() : 0;
        }
    }
    public static void main(String[] args) {
        Set<Person> set = new HashSet<Person>();
        set.add(new Person("conan", 10));
        set.add(new Person("conan", 10));
        System.out.println("셋에 저장된 데이터 수:"+set.size());
    }
}
