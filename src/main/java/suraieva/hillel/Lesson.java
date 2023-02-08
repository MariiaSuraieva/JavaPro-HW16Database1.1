package suraieva.hillel;

public class Lesson {
    int id;
    String name;
    int homeworkId;

    public Lesson(int id, String name, int homeworkId) {
        this.id = id;
        this.name = name;
        this.homeworkId = homeworkId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homeworkId=" + homeworkId +
                '}';
    }
}
