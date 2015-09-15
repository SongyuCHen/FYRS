package nju.software.fyrs.temp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nju.software.fyrs.util.CommonObjectsInList;

public class ClassProperty {
	/**
	 * 获得一个类全部属性的名字
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List<String> listClassProperties(Class clazz) {
		Field[] fields = clazz.getDeclaredFields();
		List<String> propertyNames = new ArrayList<String>();
		for (Field f : fields) {
			propertyNames.add(f.getName());
		}
		return propertyNames;
	}

	/**
	 * 由 Bean 产生一个 VO
	 * 
	 * @param clazz
	 */
	@SuppressWarnings("rawtypes")
	public static void generatorVo(Class clazz) {
		List<String> propertyNames = listClassProperties(clazz);
		for (String str : propertyNames) {
			System.out.println("private String " + str + ";");
		}
	}

	/**
	 * Bean 到 VO
	 * 
	 * @param voName
	 * @param beanName
	 * @param clazzVo
	 * @param clazzBean
	 */
	@SuppressWarnings("rawtypes")
	public static void voGetFromBean(String voName, String beanName,
			Class clazzVo, Class clazzBean) {
		// 这里默认 VO 中的值都是 String
		Field[] fields = clazzVo.getDeclaredFields();
		Map<String, String> maps = listClassPropertiesAndType(clazzBean);
		for (Field f : fields) {
			String key = f.getName();
			String keyUp = firstLetterUp(key);
			String value = maps.get(key);
			if (null == value) {
				continue;
			}
			if (value.contains("int") || value.contains("Integer")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "()+\"\");");
			}
			if (value.contains("float") || value.contains("Float")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "()+\"\");");
			}
			if (value.contains("double") || value.contains("Double")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "()+\"\");");
			}
			if (value.contains("short") || value.contains("Short")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "()+\"\");");
			}
			if (value.contains("boolean") || value.contains("Boolean")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "()+\"\");");
			}
			if (value.contains("Date")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "().toString());");
			}
			if (value.contains("String")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "());");
			}
		}

	}

	/**
	 * bean 转成 VO
	 * 
	 * @param voName
	 * @param beanName
	 * @param clazzVo
	 * @param clazzBean
	 */
	@SuppressWarnings("rawtypes")
	public static void beanGetFromVO(String voName, String beanName,
			Class clazzVo, Class clazzBean) {
		// 这里默认 VO 中的值都是 String
		Field[] fields = clazzVo.getDeclaredFields();
		Map<String, String> maps = listClassPropertiesAndType(clazzBean);
		for (Field f : fields) {
			String key = f.getName();
			String keyUp = firstLetterUp(key);
			String value = maps.get(key);
			if (null == value) {
				continue;
			}
			if (value.contains("int") || value.contains("Integer")) {
				System.out.println(beanName + ".set" + keyUp
						+ "(Integer.valueOf(" + voName + ".get" + keyUp
						+ "()));");
			}
			if (value.contains("float") || value.contains("Float")) {
				System.out
						.println(beanName + ".set" + keyUp + "(Float.valueOf("
								+ voName + ".get" + keyUp + "()));");
			}
			if (value.contains("double") || value.contains("Double")) {
				System.out.println(beanName + ".set" + keyUp
						+ "(Double.valueOf(" + voName + ".get" + keyUp
						+ "()));");
			}
			if (value.contains("short") || value.contains("Short")) {
				System.out
						.println(beanName + ".set" + keyUp + "(Short.valueOf("
								+ voName + ".get" + keyUp + "()));");
			}
			if (value.contains("boolean") || value.contains("Boolean")) {
				System.out.println(beanName + ".set" + keyUp
						+ "(Boolean.valueOf(" + voName + ".get" + keyUp
						+ "()));");
			}
			if (value.contains("Date")) {
				System.out
						.println("SimpleDateFormat format = new SimpleDateFormat(\"yyyy-MM-dd\");");
				System.out.println("Date date = format.parse(" + voName
						+ ".get" + keyUp + "());");
				System.out.println(beanName + ".set" + keyUp + "(date);");
			}
			if (value.contains("String")) {
				System.out.println(beanName + ".set" + keyUp + "(" + voName
						+ ".get" + keyUp + "());");
			}
		}

	}

	/**
	 * 获得一对类的属性名字和它的类型
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, String> listClassPropertiesAndType(Class clazz) {
		Field[] fields = clazz.getDeclaredFields();
		Map<String, String> maps = new HashMap<String, String>();
		for (Field f : fields) {
			maps.put(f.getName(), f.getType().toString());
		}
		return maps;
	}

	/**
	 * 返回一个对象的所有属性和类型
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List<MapMy> mListClassPropertiesAndType(Class clazz) {
		Field[] fields = clazz.getDeclaredFields();
		List<MapMy> list = new ArrayList<MapMy>();
		for (Field f : fields) {

			MapMy mapMy = new MapMy();
			mapMy.setName(f.getName());
			mapMy.setType(f.getType().toString());
			list.add(mapMy);
		}
		return list;
	}

	/**
	 * 只对 bean 和 vo 共有和属性进行处理
	 * 
	 * @param voName
	 * @param beanName
	 * @param list
	 */
	public static void mVoGetFromBean(String voName, String beanName,
			List<MapMy> list) {
		// 这里默认 VO 中的值都是 String

		for (MapMy m : list) {
			String key = m.getName();
			String keyUp = firstLetterUp(key);
			String value = m.getType();
			if (null == value) {
				continue;
			}
			if (value.contains("int") || value.contains("Integer")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "()+\"\");");
			}
			if (value.contains("float") || value.contains("Float")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "()+\"\");");
			}
			if (value.contains("double") || value.contains("Double")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "()+\"\");");
			}
			if (value.contains("short") || value.contains("Short")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "()+\"\");");
			}
			if (value.contains("boolean") || value.contains("Boolean")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "()+\"\");");
			}
			if (value.contains("Date")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "().toString());");
			}
			if (value.contains("String")) {
				System.out.println(voName + ".set" + keyUp + "(" + beanName
						+ ".get" + keyUp + "());");
			}
		}

	}

	public static void mBeanGetFromVO(String voName, String beanName,
			List<MapMy> list) {
		for (MapMy m : list) {
			String key = m.getName();
			String keyUp = firstLetterUp(key);
			String value = m.getType();
			if (null == value) {
				continue;
			}
			if (value.contains("int") || value.contains("Integer")) {
				System.out.println(beanName + ".set" + keyUp
						+ "(Integer.valueOf(" + voName + ".get" + keyUp
						+ "()));");
			}
			if (value.contains("float") || value.contains("Float")) {
				System.out
						.println(beanName + ".set" + keyUp + "(Float.valueOf("
								+ voName + ".get" + keyUp + "()));");
			}
			if (value.contains("double") || value.contains("Double")) {
				System.out.println(beanName + ".set" + keyUp
						+ "(Double.valueOf(" + voName + ".get" + keyUp
						+ "()));");
			}
			if (value.contains("short") || value.contains("Short")) {
				System.out
						.println(beanName + ".set" + keyUp + "(Short.valueOf("
								+ voName + ".get" + keyUp + "()));");
			}
			if (value.contains("boolean") || value.contains("Boolean")) {
				System.out.println(beanName + ".set" + keyUp
						+ "(Boolean.valueOf(" + voName + ".get" + keyUp
						+ "()));");
			}
			if (value.contains("Date")) {
				System.out
						.println("SimpleDateFormat format = new SimpleDateFormat(\"yyyy-MM-dd\");");
				System.out.println("Date date = format.parse(" + voName
						+ ".get" + keyUp + "());");
				System.out.println(beanName + ".set" + keyUp + "(date);");
			}
			if (value.contains("String")) {
				System.out.println(beanName + ".set" + keyUp + "(" + voName
						+ ".get" + keyUp + "());");
			}
		}

	}

	/**
	 * 首字母大写
	 * 
	 * @param name
	 * @return
	 */
	public static String firstLetterUp(String name) {
		char[] cs = name.toCharArray();
		if (!(cs[0] >= 65 && cs[0] <= 90)) {
			cs[0] -= 32;
		}
		return String.valueOf(cs);
	}

	/**
	 * 打印一个对象的所的值
	 * 
	 * @param clazz
	 * @param obj
	 */
	public static void printAllPropertyValue(Class<? extends Object> clazz,
			Object obj) {
		List<String> list = listClassProperties(clazz);
		try {
			for (String pName : list) {
				Method method = clazz.getMethod("get" + pName);
				Object o = method.invoke(obj);
				if (null != o) {
					System.out.println(o.toString());
				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@SuppressWarnings("rawtypes")
	public static void beanToVoFor(Class beanClazz, Class voClazz) {
		System.out.println("List<" + voClazz.getSimpleName()
				+ "> vos = new ArrayList<" + voClazz.getSimpleName() + ">();");
		System.out.println("List<" + beanClazz.getSimpleName()
				+ "> list = ddTableDAO.findAllTable();");
		System.out
				.println("for(" + beanClazz.getSimpleName() + " item : list)");
		System.out.println("{");
		System.out.println(voClazz.getSimpleName() + " vo = new "
				+ voClazz.getSimpleName() + "();");
		//
		List<MapMy> bean = mListClassPropertiesAndType(beanClazz);
		List<MapMy> vo = mListClassPropertiesAndType(voClazz);
		CommonObjectsInList<MapMy> com = new CommonObjectsInList<MapMy>();
		List<MapMy> common = com.commonObjects(bean, vo);
		mVoGetFromBean("vo", "item", common);
		//
		System.out.println("vos.add(vo);");
		System.out.println("}");
		System.out.println("return vos;");

	}

	@SuppressWarnings("rawtypes")
	public static void optionVo(String name, Class voClazz) {
		List<MapMy> vo = mListClassPropertiesAndType(voClazz);
		System.out.println("for(var i = 1; i < json.length; i++)");
		System.out.println("{");
		System.out.println(" var " + name + " = json[i];");
		for (MapMy m : vo) {
			System.out.println("html += '<option value=\"'+" + name + "."
					+ m.getName() + "+'\">'+" + name + "." + m.getName()
					+ "+'</option>';");
		}
		System.out.println("}");
	}

}

class MapMy {
	private String name;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapMy other = (MapMy) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}