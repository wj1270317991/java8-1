package com.java8.demo1;

import com.java8.demo1.model.Person;
import com.java8.proxy.ProxyController;
import com.java8.proxy.Target;
import com.java8.proxy.TargetImpl;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {


	String string = new String("good");

	char[] chars = {'a','b','c'};

	private List<Person> persons =
			Arrays.asList(
					new Person("Max", 18),
					new Person("Peter", 23),
					new Person("Pamela", 23),
					new Person("David", 12));

	@Test
	public void aa(){

		HashMap map = new HashMap();


		Demo1ApplicationTests applicationTests = new Demo1ApplicationTests();
		applicationTests.change(applicationTests.string,applicationTests.chars);
		System.out.println(applicationTests.string + "and ");
		System.out.println(applicationTests.chars);
	}


	private void change(String str,char ch[]){
		str = "test ok";
		ch[0] = 'g';
	}





	@Test
	public void contextLoads() {
//		Stream.of("a1", "a2", "a3")
//				.findFirst()
//				.ifPresent(System.out::println);
		String [] aa = new String[]{"a","b"};
		Stream.of(aa);
	}



	@Test
	public void demo1(){
//		Stream<String> stream =
//				Stream.of("d2", "a2", "b1", "b3", "c")
//						.filter(s -> s.startsWith("e"));
//		boolean b = stream.anyMatch(s -> true);
//		System.out.println(b);



		List<Person> filtered =
				persons
						.stream()
						.filter(p -> p.name.startsWith("P"))
						.collect(Collectors.toList());

		System.out.println(filtered);


	}


	@Test
	public void test2(){
//		Map<Integer, List<Person>> personsByAge = persons
//				.stream()
//				.collect(Collectors.groupingBy(p -> p.age));
//		System.out.println(personsByAge);

		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		};

		task.run();

		Thread thread = new Thread(task);
		thread.start();

		System.out.println("Done!");
	}



	@Test
	public void executor(){
		ExecutorService executor = Executors.newScheduledThreadPool(5);
		for (int i=0;i<10;i++) {
			executor.submit(() -> {
				String threadName = Thread.currentThread().getName();
				System.out.println("Hello " + threadName);
			});
		}
		executor.shutdown();
		try {
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}


	@Test
	public void callable(){
		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				return 123;
			}
			catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};


		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);

		System.out.println("future done? " + future.isDone());

		Integer result = null;
		try {
			result = future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("future done? " + future.isDone());
		System.out.print("result: " + result);
	}


	@Test
	public void invokeAll(){



		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable<String>> callables = Arrays.asList(
				() -> "task1",
				() -> "task2",
				() -> "task3");

		try {
			executor.invokeAll(callables)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        }
                        catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	@Test
	public void getNum(){
		for (int i=2;i<=100;i++){
			if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0){
				System.out.println(i);
			}
		}

//		String a = "";
//		Collections.sort(, new Comparator<Object>() {
//			@Override
//			public int compare(Object o1, Object o2) {
//				return 0;
//			}
//		});
	}


	@Test
	public void getNUm2(){
		int [] arr = {1,4,5,44,2,4,213,11,44,33};
//		for (int i= 0 ;i<ii.length/2;i++){
//			int tmp = ii[ii.length - i -1];
//			ii[ii.length - i -1] = ii[i];
//			ii[i] = tmp;
//		}
//		for (int j= 0 ;j<ii.length;j++){
//			System.out.println(ii[j]);
//		}

		for (int x=0,y=arr.length-1;x<y;x++,y--){
			int tmp = arr[y];
			arr[y] = arr[x];
			arr[x] = tmp;
		}
		for (int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}




	}




	@Test
	public void testFile() throws IOException {
//		File file = new File("./info/aa");
//		FileInputStream fs = new FileInputStream(file);
//		byte b[] = new byte[2048];
//		int len;
//		while (( len = fs.read(b)) != -1 ){
//			for (int i=0;i<len;i++){
//				System.out.println((char)b[i]);
//			}
//
//		}
//		BufferedInputStream bfi = new BufferedInputStream(fs);
//		BufferedWriter bufferedWriter= null;

//		if (!file.exists()){
//			file.mkdir();
//			file.createNewFile();
//		}
		//file.delete();
	}


	@Test
	public void testThread(){

	}


	@Test
	public void testStr1(){
		String a = "adnfdfdlfdfdeoeodffd";
		           //dffdoeoedfdfldfdfnda
//		String b = "fd";
//		int index;
//		int count = 0;
//		while ((index = a.indexOf(b)) != -1){
//			count++;
//			a = a.substring(index+b.length());
//		}
//		System.out.println(count);
//		char[] chars = a.toCharArray();
//		char[] chars1 = new char[chars.length];
////		for (int i= 0;i<chars.length;i++){
////			chars1[i] = chars[chars.length-1-i];
////		}
//		char tmp;
//		for (int i=0,j=chars.length-1; i<j; i++,j--){
//			tmp = chars[i];
//			chars[i] = chars[j];
//			chars[j] = tmp;
//		}
//		System.out.println(chars);
//		//System.out.println(chars1);
//
//		StringBuilder stringBuilder = new StringBuilder();
//		SimpleDateFormat aDate=new SimpleDateFormat("yyyyMMdd-hhmm");
//		System.out.println(LocalDateTime.now());
//		System.out.println(aDate.format(aDate));
	}



	@Test
	public void date(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		try {
			Connection connection = DriverManager.getConnection("","","");
			Statement statement = connection.createStatement();
//			PreparedStatement preparedStatement = connection.prepareStatement();
//			preparedStatement.addBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Properties properties = new Properties();
		return;
	}



	@Test
	public void proxyTest(){
		ProxyController proxyController = new ProxyController();
		Target target = new TargetImpl();
		Target bind = (Target)proxyController.bind(target);
		int add = bind.add(1, 4);
		System.out.println(add);
	}


	/**
	 * 判断（这是一个错误的事例）
	 * <dependency>
	 	<groupId>org.apache.commons</groupId>
	 	<artifactId>commons-lang3</artifactId>
	 	<version>3.5</version>
	   </dependency>
	 */
	@Test
	public void objectUtilsAllNotNull(){
		Person person = null;
		//错误的
		System.out.println(person == null);
		if (ObjectUtils.allNotNull(person,person.name,person.age)){
			System.out.println("哈哈哈");
		}

//		if (person != null && person.name != null){
//			System.out.println("hehehe");
//		}
	}


}
