import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, 0, size(), null);
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume resume = null;
        for (Resume value : storage) {
            if (value != null) {
                if (uuid.equals(value.uuid)) {
                    resume = value;
                    break;
                }
            }
        }
        return resume;
    }

    void delete(String uuid) {
        int index = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (uuid.equals(storage[i].uuid)) {
                    index = i;
                    break;
                }
            }
        }
        if (index == 0) {
            Resume[] storageCopy = new Resume[storage.length-1];
            System.arraycopy(storage, 1, storageCopy, 0, storageCopy.length);
            storage = storageCopy;
        }
        else if (index == storage.length-1) {
            Resume[] storageCopy = new Resume[storage.length-1];
            for (int i = 0; i < storage.length-1; i++) {
                storageCopy[i] = storage[i];
            }
            storage = storageCopy;
        }
        else {
            Resume[] storageCopy = new Resume[storage.length-1];
            for (int i = 0; i < storage.length; i++) {
                if (i > index) {
                    storageCopy[i-1] = storage[i];
                }
                if (i == index) {
                    continue;
                }
                if (i < index) {
                    storageCopy[i] = storage[i];
                }
            }
            storage = storageCopy;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
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
