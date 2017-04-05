package library.utils;

import library.models.*;
import library.models.Reader;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 05.04.2017.
 */
public class DataManager {




    public static <T> void externalizeObj(Collection<T> objects, Class className)
    {

        String classNameStr = className.getSimpleName();

        try(FileOutputStream fos = new FileOutputStream(classNameStr + ".txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (T object: objects)
            {
                oos.writeObject(object);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static <T> Collection<T> unexternalizeFromFileObject(Collection<T> emptyCollection,
                                                                Class className)
    {
        Collection<T> objects = emptyCollection;
        String classNameStr = className.getSimpleName();
        try(FileInputStream fis = new FileInputStream(classNameStr + ".txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            T object = null;
            while ( (object = (T) ois.readObject()) != null)
            {
                objects.add(object);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            return objects;
        }

    }


}
