package Week01;



import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;




public class HelloClassLoader extends ClassLoader{
    public static void main(String[] args){

        try {
            final Class<?> clazz = new HelloClassLoader().findClass("Hello");
            Method helloMethod = clazz.getMethod("hello");
            helloMethod.invoke(clazz.newInstance());
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("F:\\jva\\week01\\src\\Week01\\Hello.xlass");
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            fis.read(buffer);
            for (int i = 0;i < buffer.length;i++) {
                buffer[i] = (byte) ((byte) 255 - buffer[i]);
            }
            return defineClass(name,buffer,0,buffer.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

