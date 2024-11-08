package backlog;

interface GeneralBook {
    int size(); // 인수 없이 사용하기!!!
    String names();
    String records();
    boolean nameExist(String name);
    void add(String name, String record);
    void remove(String name);
    String get(String name);
    void sort();
    void print();
}

class ArrayedGeneralBook implements GeneralBook {
    String[] names;
    String[] records;

    ArrayedGeneralBook(String[] names, String[] records) {
        this.names = names;
        this.records = records;
    }

    public int size() {
        return this.names.length;
    }

    public String names() {
        int count = size();
        StringBuilder namesString = new StringBuilder();
        for (int i = 0; i < count; i++) {
            namesString.append(this.names[i]);
            if (i < count - 1) namesString.append(", ");
        }
        return namesString.toString();
    }

    public String records() {
        int count = size();
        StringBuilder recordsString = new StringBuilder();
        for (int i = 0; i < count; i++) {
            recordsString.append(this.records[i]);
            if (i < count - 1) recordsString.append(", ");
        }
        return recordsString.toString();
    }

    public boolean nameExist(String name) {
        for (String n:names) {
            if (n.equals(name)) {
                return true;
            }
        }
        return false;
    }
    public void add(String name, String record) {
        int count = size();

        if (nameExist(name)) {
            System.out.println(name + " already exists in the book. Cannot add duplicate.");
            return;
        }

        String[] newNames = new String[count + 1];
        String[] newRecords = new String[count + 1];

        for (int i = 0; i < count; i++) {
            newNames[i] = names[i];
            newRecords[i] = records[i];
        }

        newNames[count] = name;
        newRecords[count] = record;

        names = newNames;
        records = newRecords;
        count++;

        sort();
    }


    public void remove(String name) {
        int count = size();
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (names[i].equals(name)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Name " + name + " not found. Cannot remove.");
            return;
        }

        String[] newNames = new String[count - 1];
        String[] newRecords = new String[count - 1];

        for (int i = 0, j = 0; i < count; i++) {
            if (i != index) {
                newNames[j] = names[i];
                newRecords[j] = records[i];
                j++;
            }
        }

        names = newNames;
        records = newRecords;
        count--;
    }

    public String get(String name) {
        int count = size();
        for (int i = 0; i < count; i++) {
            if (names[i].equals(name)) {
                return records[i];
            }
        }
        return "Record not found.";
    }


    public void sort() {
        int count = size();
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (names[i].compareTo(names[j]) > 0) {
                    String tempName = names[i];
                    String tempRecord = records[i];
                    names[i] = names[j];
                    records[i] = records[j];
                    names[j] = tempName;
                    records[j] = tempRecord;
                }
            }
        }
    }


    public void print() {
        int count = size();
        System.out.println("Name - Record");
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " - " + records[i]);
        }
    }
}

public class GeneralBookEx {
    public static void main(String[] args) {
        String[] names = {"Sam", "Rhee", "Kim"};
        String[] records = {"1111", "2222", "3333"};
        ArrayedGeneralBook gb = new ArrayedGeneralBook(names, records);

        System.out.println("Names: " + gb.names());
        gb.add("Alian", "4444");
        gb.print();

        System.out.println("Current data size: " + gb.size());
        gb.print();

        System.out.println("Does 'Alex' exist? " + gb.nameExist("Alex"));
        gb.remove("Alex");

        gb.remove("Sam");
        gb.print();

        String foundRecord = gb.get("Alian");
        System.out.println("Record found for Alian: " + foundRecord);
    }
}
