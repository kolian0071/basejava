import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = size();

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i])) {
                resume = storage[i];
            }
        }
        return resume;
    }

    void delete(String uuid) {
        int index = 0;
        boolean delete = false;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                index = i;
                delete = true;
            }
        }
        if (delete) {
            for (int i = index; i < size - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage[size - 1] = null;
            delete = false;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                size++;
            }
        }
        return size;
    }
}
