package nju.software.fyrs.util;

import java.io.File;

import org.apache.log4j.Logger;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * 
 * jacob����MSword��
 * 
 * @author
 */

public class JacobHelper {

	private static Logger logger = Logger.getLogger(JacobHelper.class);
	// word�ĵ�

	private Dispatch doc;

	// word���г������

	private ActiveXComponent word;

	// ����word�ĵ�����

	private Dispatch documents;

	// ѡ���ķ�Χ������

	private Dispatch selection;
	
	//ȡ�û������� 
	private Dispatch activeWindow;     
  


	private boolean saveOnExit = true;

	public JacobHelper(boolean visible) throws Exception {

		ComThread.InitSTA();// ��ʼ��com���̣߳��ǳ���Ҫ����ʹ�ý�����Ҫ���� realease����

		if (word == null) {

			word = new ActiveXComponent("Word.Application");

			word.setProperty("Visible", new Variant(visible)); // �����Ƿ�ɼ���word

			word.setProperty("AutomationSecurity", new Variant(3)); // ���ú�

		}

		if (documents == null)

			documents = word.getProperty("Documents").toDispatch();

	}

	/**
	 * 
	 * �����˳�ʱ����
	 * 
	 * 
	 * 
	 * @param saveOnExit
	 * 
	 *            boolean true-�˳�ʱ�����ļ���false-�˳�ʱ�������ļ�
	 */

	public void setSaveOnExit(boolean saveOnExit) {

		this.saveOnExit = saveOnExit;

	}

	/**
	 * 
	 * ����һ���µ�word�ĵ�
	 * 
	 * 
	 */

	public void createNewDocument() {

		doc = Dispatch.call(documents, "Add").toDispatch();
		
		if (activeWindow == null) {
			activeWindow = word.getProperty("ActiveWindow").toDispatch(); 
		}

		selection = Dispatch.get(word, "Selection").toDispatch();

	}

	/**
	 * 
	 * ��һ���Ѵ��ڵ��ĵ�
	 * 
	 * 
	 * 
	 * @param docPath
	 */

	public void openDocument(String docPath) {

		closeDocument();

		doc = Dispatch.call(documents, "Open", docPath).toDispatch();

		selection = Dispatch.get(word, "Selection").toDispatch();

	}

	/**
	 * 
	 * ֻ�� ��һ�������ĵ�,
	 * 
	 * @param docPath
	 *            -�ļ�ȫ��
	 * 
	 * @param pwd
	 *            -����
	 */

	public void openDocumentOnlyRead(String docPath, String pwd)
			throws Exception {

		closeDocument();

		// doc = Dispatch.invoke(documents, "Open", Dispatch.Method,

		// new Object[]{docPath, new Variant(false), new Variant(true), new
		// Variant(true), pwd},

		// new int[1]).toDispatch();//��word�ļ�

		doc = Dispatch.callN(
				documents,
				"Open",
				new Object[] { docPath, new Variant(false),

				new Variant(true), new Variant(true), pwd, "",
						new Variant(false) }).toDispatch();

		selection = Dispatch.get(word, "Selection").toDispatch();

	}

	public void openDocument(String docPath, String pwd) throws Exception {

		closeDocument();

		doc = Dispatch.callN(documents, "Open",
				new Object[] { docPath, new Variant(false),

				new Variant(false), new Variant(true), pwd }).toDispatch();

		selection = Dispatch.get(word, "Selection").toDispatch();

	}

	/**
	 * 
	 * ��ѡ�������ݻ����������ƶ�
	 * 
	 * 
	 * 
	 * @param pos
	 * 
	 *            �ƶ��ľ���
	 */

	public void moveUp(int pos) {

		if (selection == null)

			selection = Dispatch.get(word, "Selection").toDispatch();

		for (int i = 0; i < pos; i++)

			Dispatch.call(selection, "MoveUp");

	}

	/**
	 * 
	 * ��ѡ�������ݻ��߲���������ƶ�
	 * 
	 * 
	 * 
	 * @param pos
	 * 
	 *            �ƶ��ľ���
	 */

	public void moveDown(int pos) {

		if (selection == null)

			selection = Dispatch.get(word, "Selection").toDispatch();

		for (int i = 0; i < pos; i++)

			Dispatch.call(selection, "MoveDown");

	}

	/**
	 * 
	 * ��ѡ�������ݻ��߲���������ƶ�
	 * 
	 * 
	 * 
	 * @param pos
	 * 
	 *            �ƶ��ľ���
	 */

	public void moveLeft(int pos) {

		if (selection == null)

			selection = Dispatch.get(word, "Selection").toDispatch();

		for (int i = 0; i < pos; i++) {

			Dispatch.call(selection, "MoveLeft");

		}

	}

	/**
	 * 
	 * ��ѡ�������ݻ��߲���������ƶ�
	 * 
	 * 
	 * 
	 * @param pos
	 * 
	 *            �ƶ��ľ���
	 */

	public void moveRight(int pos) {

		if (selection == null)

			selection = Dispatch.get(word, "Selection").toDispatch();

		for (int i = 0; i < pos; i++)

			Dispatch.call(selection, "MoveRight");

	}

	/**
	 * 
	 * �Ѳ�����ƶ����ļ���λ��
	 * 
	 * 
	 */

	public void moveStart() {

		if (selection == null)

			selection = Dispatch.get(word, "Selection").toDispatch();

		Dispatch.call(selection, "HomeKey", new Variant(6));

	}

	/**
	 * 
	 * ��ѡ�����ݻ����㿪ʼ�����ı�
	 * 
	 * 
	 * 
	 * @param toFindText
	 * 
	 *            Ҫ���ҵ��ı�
	 * 
	 * @return boolean true-���ҵ���ѡ�и��ı���false-δ���ҵ��ı�
	 */

	@SuppressWarnings("static-access")
	public boolean find(String toFindText) {

		if (toFindText == null || toFindText.equals(""))

			return false;

		// ��selection����λ�ÿ�ʼ��ѯ

		Dispatch find = word.call(selection, "Find").toDispatch();

		// ����Ҫ���ҵ�����

		Dispatch.put(find, "Text", toFindText);

		// ��ǰ����

		Dispatch.put(find, "Forward", "True");

		// ���ø�ʽ

		Dispatch.put(find, "Format", "True");

		// ��Сдƥ��

		Dispatch.put(find, "MatchCase", "True");

		// ȫ��ƥ��

		Dispatch.put(find, "MatchWholeWord", "True");

		// ���Ҳ�ѡ��

		return Dispatch.call(find, "Execute").getBoolean();

	}

	/**
	 * 
	 * ��ѡ��ѡ�������趨Ϊ�滻�ı�
	 * 
	 * 
	 * 
	 * @param toFindText
	 * 
	 *            �����ַ���
	 * 
	 * @param newText
	 * 
	 *            Ҫ�滻������
	 * 
	 * @return
	 */

	public boolean replaceText(String toFindText, String newText) {

		if (!find(toFindText))

			return false;

		Dispatch.put(selection, "Text", newText);

		return true;

	}

	/**
	 * 
	 * ȫ���滻�ı�
	 * 
	 * 
	 * 
	 * @param toFindText
	 * 
	 *            �����ַ���
	 * 
	 * @param newText
	 * 
	 *            Ҫ�滻������
	 */

	public void replaceAllText(String toFindText, String newText) {

		while (find(toFindText)) {

			Dispatch.put(selection, "Text", newText);

			Dispatch.call(selection, "MoveRight");

		}

	}

	/**
	 * 
	 * �ڵ�ǰ���������ַ���
	 * 
	 * 
	 * 
	 * @param newText
	 * 
	 *            Ҫ��������ַ���
	 */

	public void insertText(String newText, boolean bold, boolean italic, boolean underLine,

			String colorSize, String size, String name) {

		if (StringUtil.isEmpty(newText)) {
			return;
		}
		//Dispatch.put(selection, "Text", newText);
		Dispatch.call(selection, "InsertAfter", newText);
		setFont(bold, italic, underLine, colorSize, size, name);
		moveLeft(1);
		moveRight(newText.length());

	}
	
	/**
	 * ������������insertText������moveRightȥ��
	 * @param newText
	 * @param bold
	 * @param italic
	 * @param underLine
	 * @param colorSize
	 * @param size
	 * @param name
	 */
	public void insertTextNoMoveRight(String newText, boolean bold, boolean italic, boolean underLine,

			String colorSize, String size, String name) {

		//Dispatch.put(selection, "Text", newText);
		Dispatch.call(selection, "InsertAfter", newText);
		setFont(bold, italic, underLine, colorSize, size, name);
		//moveRight(newText.length());

	}
	
	public void enterDown(int count){          
		for(int i = 0;i < count;i++) {      
			Dispatch.call(this.selection, "TypeParagraph");      
		}      
	} 
	


	/**
	 * 
	 * 
	 * 
	 * @param toFindText
	 * 
	 *            Ҫ���ҵ��ַ���
	 * 
	 * @param imagePath
	 * 
	 *            ͼƬ·��
	 * 
	 * @return
	 */

	public boolean replaceImage(String toFindText, String imagePath) {

		if (!find(toFindText))

			return false;

		Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(),

		"AddPicture", imagePath);

		return true;

	}

	/**
	 * 
	 * ȫ���滻ͼƬ
	 * 
	 * 
	 * 
	 * @param toFindText
	 * 
	 *            �����ַ���
	 * 
	 * @param imagePath
	 * 
	 *            ͼƬ·��
	 */

	public void replaceAllImage(String toFindText, String imagePath) {

		while (find(toFindText)) {

			Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(),

			"AddPicture", imagePath);

			Dispatch.call(selection, "MoveRight");

		}

	}

	/**
	 * 
	 * �ڵ�ǰ��������ͼƬ
	 * 
	 * 
	 * 
	 * @param imagePath
	 * 
	 *            ͼƬ·��
	 */

	public void insertImage(String imagePath) {

		Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(),

		"AddPicture", imagePath);

	}
	
	public boolean insertImage(byte imageByte[], String imageSavePath) {
		
		File image = new File(imageSavePath);

		if (image.exists()) {
			/*try {
				FileOutputStream out = new FileOutputStream(image);
				out.write(imageByte, 0, imageByte.length);
				out.close();
			} catch (Exception e) {
				
				logger.error("����ͼƬʧ�ܣ�" + imageSavePath,e);
			}*/
			Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(), "AddPicture", imageSavePath);
			return true;
		}else {
			return false;
		}
		
		
	}

	/**
	 * 
	 * �ϲ���Ԫ��
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 * @param fstCellRowIdx
	 * 
	 * @param fstCellColIdx
	 * 
	 * @param secCellRowIdx
	 * 
	 * @param secCellColIdx
	 */

	public void mergeCell(int tableIndex, int fstCellRowIdx, int fstCellColIdx,

	int secCellRowIdx, int secCellColIdx) {

		// ���б��

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		// Ҫ���ı��

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		Dispatch fstCell = Dispatch.call(table, "Cell",

		new Variant(fstCellRowIdx), new Variant(fstCellColIdx))

		.toDispatch();

		Dispatch secCell = Dispatch.call(table, "Cell",

		new Variant(secCellRowIdx), new Variant(secCellColIdx))

		.toDispatch();

		Dispatch.call(fstCell, "Merge", secCell);

	}

	/**
	 * 
	 * ��ָ���ĵ�Ԫ������д����
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 * @param cellRowIdx
	 * 
	 * @param cellColIdx
	 * 
	 * @param txt
	 */

	public void putTxtToCell(int tableIndex, int cellRowIdx, int cellColIdx,

	String txt) {

		// ���б��

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		// Ҫ���ı��

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		Dispatch cell = Dispatch.call(table, "Cell", new Variant(cellRowIdx),

		new Variant(cellColIdx)).toDispatch();

		Dispatch.call(cell, "Select");

		Dispatch.put(selection, "Text", txt);

	}

	/**
	 * 
	 * ���ָ���ĵ�Ԫ��������
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 * @param cellRowIdx
	 * 
	 * @param cellColIdx
	 * 
	 * @return
	 */

	public String getTxtFromCell(int tableIndex, int cellRowIdx, int cellColIdx) {

		// ���б��

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		// Ҫ���ı��

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		Dispatch cell = Dispatch.call(table, "Cell", new Variant(cellRowIdx),

		new Variant(cellColIdx)).toDispatch();

		Dispatch.call(cell, "Select");

		String ret = "";

		ret = Dispatch.get(selection, "Text").toString();

		ret = ret.substring(0, ret.length() - 1); // ȥ�����Ļس���;

		return ret;

	}

	/**
	 * 
	 * �ڵ�ǰ�ĵ���������������
	 * 
	 * @param pos
	 */

	public void pasteExcelSheet(String pos) {

		moveStart();

		if (this.find(pos)) {

			Dispatch textRange = Dispatch.get(selection, "Range").toDispatch();

			Dispatch.call(textRange, "Paste");

		}

	}

	/**
	 * 
	 * �ڵ�ǰ�ĵ�ָ����λ�ÿ������
	 * 
	 * 
	 * 
	 * @param pos
	 * 
	 *            ��ǰ�ĵ�ָ����λ��
	 * 
	 * @param tableIndex
	 * 
	 *            �������ı����word�ĵ���������λ��
	 */

	public void copyTable(String pos, int tableIndex) {

		// ���б��

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		// Ҫ���ı��

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		Dispatch range = Dispatch.get(table, "Range").toDispatch();

		Dispatch.call(range, "Copy");

		if (this.find(pos)) {

			Dispatch textRange = Dispatch.get(selection, "Range").toDispatch();

			Dispatch.call(textRange, "Paste");

		}

	}

	/**
	 * 
	 * �ڵ�ǰ�ĵ�ָ����λ�ÿ���������һ���ĵ��еı��
	 * 
	 * 
	 * 
	 * @param anotherDocPath
	 * 
	 *            ��һ���ĵ��Ĵ���·��
	 * 
	 * @param tableIndex
	 * 
	 *            �������ı������һ���ĵ��е�λ��
	 * 
	 * @param pos
	 * 
	 *            ��ǰ�ĵ�ָ����λ��
	 */

	public void copyTableFromAnotherDoc(String anotherDocPath, int tableIndex,

	String pos) {

		Dispatch doc2 = null;

		try {

			doc2 = Dispatch.call(documents, "Open", anotherDocPath)

			.toDispatch();

			// ���б��

			Dispatch tables = Dispatch.get(doc2, "Tables").toDispatch();

			// Ҫ���ı��

			Dispatch table = Dispatch.call(tables, "Item",

			new Variant(tableIndex)).toDispatch();

			Dispatch range = Dispatch.get(table, "Range").toDispatch();

			Dispatch.call(range, "Copy");

			if (this.find(pos)) {

				Dispatch textRange = Dispatch.get(selection, "Range")

				.toDispatch();

				Dispatch.call(textRange, "Paste");

			}

		} catch (Exception e) {

			
			logger.error("", e);
		} finally {

			if (doc2 != null) {

				Dispatch.call(doc2, "Close", new Variant(saveOnExit));

				doc2 = null;

			}

		}

	}

	/**
	 * 
	 * �ڵ�ǰ�ĵ�ָ����λ�ÿ���������һ���ĵ��е�ͼƬ
	 * 
	 * 
	 * 
	 * @param anotherDocPath
	 *            ��һ���ĵ��Ĵ���·��
	 * 
	 * @param shapeIndex
	 *            ��������ͼƬ����һ���ĵ��е�λ��
	 * 
	 * @param pos
	 *            ��ǰ�ĵ�ָ����λ��
	 */

	public void copyImageFromAnotherDoc(String anotherDocPath, int shapeIndex,

	String pos) {

		Dispatch doc2 = null;

		try {

			doc2 = Dispatch.call(documents, "Open", anotherDocPath)

			.toDispatch();

			Dispatch shapes = Dispatch.get(doc2, "InLineShapes").toDispatch();

			Dispatch shape = Dispatch.call(shapes, "Item",

			new Variant(shapeIndex)).toDispatch();

			Dispatch imageRange = Dispatch.get(shape, "Range").toDispatch();

			Dispatch.call(imageRange, "Copy");

			if (this.find(pos)) {

				Dispatch textRange = Dispatch.get(selection, "Range")

				.toDispatch();

				Dispatch.call(textRange, "Paste");

			}

		} catch (Exception e) {

			logger.error("", e);

		} finally {

			if (doc2 != null) {

				Dispatch.call(doc2, "Close", new Variant(saveOnExit));

				doc2 = null;

			}

		}

	}

	/**
	 * 
	 * �������
	 * 
	 * 
	 * 
	 * @param pos
	 * 
	 *            λ��
	 * 
	 * @param cols
	 * 
	 *            ����
	 * 
	 * @param rows
	 * 
	 *            ����
	 */

	public void createTable(String pos, int numCols, int numRows) {

		if (find(pos)) {

			Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

			Dispatch range = Dispatch.get(selection, "Range").toDispatch();

			@SuppressWarnings("unused")
			Dispatch newTable = Dispatch.call(tables, "Add", range,

			new Variant(numRows), new Variant(numCols)).toDispatch();

			Dispatch.call(selection, "MoveRight");

		} else {

			Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

			Dispatch range = Dispatch.get(selection, "Range").toDispatch();

			@SuppressWarnings("unused")
			Dispatch newTable = Dispatch.call(tables, "Add", range,

			new Variant(numRows), new Variant(numCols)).toDispatch();

			Dispatch.call(selection, "MoveRight");

		}

	}

	/**
	 * 
	 * ��ָ����ǰ��������
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 *            word�ļ��еĵ�N�ű�(��1��ʼ)
	 * 
	 * @param rowIndex
	 * 
	 *            ָ���е����(��1��ʼ)
	 */

	public void addTableRow(int tableIndex, int rowIndex) {

		// ���б��

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		// Ҫ���ı��

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		// ����������

		Dispatch rows = Dispatch.get(table, "Rows").toDispatch();

		Dispatch row = Dispatch.call(rows, "Item", new Variant(rowIndex))

		.toDispatch();

		Dispatch.call(rows, "Add", new Variant(row));

	}

	/**
	 * 
	 * �ڵ�1��ǰ����һ��
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 *            word�ĵ��еĵ�N�ű�(��1��ʼ)
	 */

	public void addFirstTableRow(int tableIndex) {

		// ���б��

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		// Ҫ���ı��

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		// ����������

		Dispatch rows = Dispatch.get(table, "Rows").toDispatch();

		Dispatch row = Dispatch.get(rows, "First").toDispatch();

		Dispatch.call(rows, "Add", new Variant(row));

	}

	/**
	 * 
	 * �����1��ǰ����һ��
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 *            word�ĵ��еĵ�N�ű�(��1��ʼ)
	 */

	public void addLastTableRow(int tableIndex) {

		// ���б��

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		// Ҫ���ı��

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		// ����������

		Dispatch rows = Dispatch.get(table, "Rows").toDispatch();

		Dispatch row = Dispatch.get(rows, "Last").toDispatch();

		Dispatch.call(rows, "Add", new Variant(row));

	}

	/**
	 * 
	 * ����һ��
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 *            word�ĵ��еĵ�N�ű�(��1��ʼ)
	 */

	public void addRow(int tableIndex) {

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		// Ҫ���ı��

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		// ����������

		Dispatch rows = Dispatch.get(table, "Rows").toDispatch();

		Dispatch.call(rows, "Add");

	}

	/**
	 * 
	 * ����һ��
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 *            word�ĵ��еĵ�N�ű�(��1��ʼ)
	 */

	public void addCol(int tableIndex) {

		// ���б��

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		// Ҫ���ı��

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		// ����������

		Dispatch cols = Dispatch.get(table, "Columns").toDispatch();

		Dispatch.call(cols, "Add").toDispatch();

		Dispatch.call(cols, "AutoFit");

	}

	/**
	 * 
	 * ��ָ����ǰ�����ӱ�����
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 *            word�ĵ��еĵ�N�ű�(��1��ʼ)
	 * 
	 * @param colIndex
	 * 
	 *            �ƶ��е���� (��1��ʼ)
	 */

	public void addTableCol(int tableIndex, int colIndex) {

		// ���б��

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		// Ҫ���ı��

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		// ����������

		Dispatch cols = Dispatch.get(table, "Columns").toDispatch();

		System.out.println(Dispatch.get(cols, "Count"));

		Dispatch col = Dispatch.call(cols, "Item", new Variant(colIndex))

		.toDispatch();

		// Dispatch col = Dispatch.get(cols, "First").toDispatch();

		Dispatch.call(cols, "Add", col).toDispatch();

		Dispatch.call(cols, "AutoFit");

	}

	/**
	 * 
	 * �ڵ�1��ǰ����һ��
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 *            word�ĵ��еĵ�N�ű�(��1��ʼ)
	 */

	public void addFirstTableCol(int tableIndex) {

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		// Ҫ���ı��

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		// ����������

		Dispatch cols = Dispatch.get(table, "Columns").toDispatch();

		Dispatch col = Dispatch.get(cols, "First").toDispatch();

		Dispatch.call(cols, "Add", col).toDispatch();

		Dispatch.call(cols, "AutoFit");

	}

	/**
	 * 
	 * �����һ��ǰ����һ��
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 *            word�ĵ��еĵ�N�ű�(��1��ʼ)
	 */

	public void addLastTableCol(int tableIndex) {

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		// Ҫ���ı��

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		// ����������

		Dispatch cols = Dispatch.get(table, "Columns").toDispatch();

		Dispatch col = Dispatch.get(cols, "Last").toDispatch();

		Dispatch.call(cols, "Add", col).toDispatch();

		Dispatch.call(cols, "AutoFit");

	}

	/**
	 * 
	 * �Զ��������
	 * 
	 * 
	 */

	@SuppressWarnings("deprecation")
	public void autoFitTable() {

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		int count = Dispatch.get(tables, "Count").toInt();

		for (int i = 0; i < count; i++) {

			Dispatch table = Dispatch.call(tables, "Item", new Variant(i + 1))

			.toDispatch();

			Dispatch cols = Dispatch.get(table, "Columns").toDispatch();

			Dispatch.call(cols, "AutoFit");

		}

	}

	/**
	 * 
	 * ����word��ĺ��Ե������Ŀ��,���к걣����document��
	 * 
	 * 
	 */

	@SuppressWarnings("deprecation")
	public void callWordMacro() {

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		int count = Dispatch.get(tables, "Count").toInt();

		Variant vMacroName = new Variant("Normal.NewMacros.tableFit");

		@SuppressWarnings("unused")
		Variant vParam = new Variant("param1");

		@SuppressWarnings("unused")
		Variant para[] = new Variant[] { vMacroName };

		for (int i = 0; i < count; i++) {

			Dispatch table = Dispatch.call(tables, "Item", new Variant(i + 1))

			.toDispatch();

			Dispatch.call(table, "Select");

			Dispatch.call(word, "Run", "tableFitContent");

		}

	}
	
	/**
	 * ����ѡ�ж�����ˮƽ���䷽ʽ
	 * @param Align
	 */
	public void setCellAlignment(int Align) {
		Dispatch paragraphs = Dispatch.get(selection, "Paragraphs").toDispatch();
		Dispatch.put(paragraphs, "Alignment", new Variant(Align));
	}
	
	public void setPageSetup(int paperSize) {
		Dispatch pagesetup = Dispatch.get(selection, "PageSetup").toDispatch();
		Dispatch.put(pagesetup, "PaperSize", new Variant(paperSize));
	}

	/**
	 * ����ҳ���ʽ
	 * @param paperSize
	 * @param topMargin
	 * @param rightMargin
	 * @param bottomMargin
	 * @param leftMargin
	 * @param pageNumber
	 */
	public void setPage(int paperSize, double topMargin, double rightMargin,
			double bottomMargin, double leftMargin, boolean pageNumber) {
		Dispatch pagesetup = Dispatch.get(selection, "PageSetup").toDispatch();
		Dispatch.put(pagesetup, "TopMargin", new Variant(topMargin));
		Dispatch.put(pagesetup, "RightMargin", new Variant(rightMargin));
		Dispatch.put(pagesetup, "BottomMargin", new Variant(bottomMargin));
		Dispatch.put(pagesetup, "LeftMargin", new Variant(leftMargin));
		Dispatch.put(pagesetup, "PaperSize", new Variant(paperSize));
		
		if (pageNumber) {
			//ȡ�û�������   
			Dispatch ActivePane = Dispatch.get(activeWindow, "ActivePane").toDispatch();   
			//ȡ���Ӵ�����   
			Dispatch View = Dispatch.get(ActivePane, "View").toDispatch();
			Dispatch.put(View, "SeekView", new Variant(10));
			
			Dispatch footer = Dispatch.get(selection, "HeaderFooter").toDispatch(); 
			Dispatch pageNumbers = Dispatch.get(footer, "PageNumbers").toDispatch();
			Dispatch.call(pageNumbers, "Add", new Variant(1));

			Dispatch.put(View, "SeekView", new Variant(9));
			Dispatch.call(selection, "WholeStory");
			Dispatch borders = Dispatch.get(selection, "Borders").toDispatch();
			Dispatch.put(borders, "OutsideLineStyle", new Variant(0));
			
			Dispatch.put(View, "SeekView", new Variant(0));  
		}
		
	}

	/**
	 * 
	 * ���õ�ǰѡ�����ݵ�����
	 * 
	 * 
	 * 
	 * @param boldSize
	 * 
	 * @param italicSize
	 * 
	 * @param underLineSize
	 * 
	 *            �»���
	 * 
	 * @param colorSize
	 * 
	 *            ������ɫ
	 * 
	 * @param size
	 * 
	 *            �����С
	 * 
	 * @param name
	 * 
	 *            ��������
	 */

	public void setFont(boolean bold, boolean italic, boolean underLine,

	String colorSize, String size, String name) {

		Dispatch font = Dispatch.get(selection, "Font").toDispatch();

		Dispatch.put(font, "Name", new Variant(name));

		Dispatch.put(font, "Bold", new Variant(bold));

		Dispatch.put(font, "Italic", new Variant(italic));

		Dispatch.put(font, "Underline", new Variant(underLine));

		Dispatch.put(font, "Color", colorSize);

		Dispatch.put(font, "Size", size);

	}

	/**
	 * 
	 * ���õ�Ԫ��ѡ��
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 * @param cellRowIdx
	 * 
	 * @param cellColIdx
	 */

	public void setTableCellSelected(int tableIndex, int cellRowIdx,
			int cellColIdx) {

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		Dispatch cell = Dispatch.call(table, "Cell", new Variant(cellRowIdx),

		new Variant(cellColIdx)).toDispatch();

		Dispatch.call(cell, "Select");

	}
	
	/**
	 * 
	 * �����б�ѡ��
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 * @param cellRowIdx
	 * 
	 * @param cellColIdx
	 */

	public void setTableRowSelected(int tableIndex, int cellRowIdx) {

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		Dispatch row = Dispatch.call(table, "Rows", new Variant(cellRowIdx)).toDispatch();

		Dispatch.call(row, "Select");

	}
	
	/**
	 * 
	 * �����б�ѡ��
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 * @param cellRowIdx
	 * 
	 * @param cellColIdx
	 */

	public void setTableColSelected(int tableIndex, int cellColIdx) {

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		Dispatch column = Dispatch.call(table, "Columns", new Variant(cellColIdx)).toDispatch();

		Dispatch.call(column, "Select");

	}
	
	/**
	 * 
	 * �����������ѡ��
	 * 
	 * 
	 * 
	 * @param tableIndex
	 * 
	 * @param cellRowIdx
	 * 
	 * @param cellColIdx
	 */

	public void setTableSelected(int tableIndex) {

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))

		.toDispatch();

		Dispatch.call(table, "Select");

	}
	
	

	/**
	 * 
	 * ����ѡ����Ԫ��Ĵ�ֱ����ʽ, ��ʹ��setTableCellSelectedѡ��һ����Ԫ��
	 * 
	 * @param align
	 *            0-����, 1-����, 3-�׶�
	 */

	public void setCellVerticalAlign(int verticalAlign) {

		Dispatch cells = Dispatch.get(selection, "Cells").toDispatch();

		Dispatch.put(cells, "VerticalAlignment", new Variant(verticalAlign));

	}
	
	/**
	 * ����ѡ�е�Ԫ��Ŀ��
	 * @param width
	 */
	public void setCellSetWidth(Integer ruleStyle, double columnWidth) {
		Dispatch cells = Dispatch.get(selection, "Cells").toDispatch();
		Dispatch.call(cells, "RulerStyle", new Variant(ruleStyle));
		Dispatch.call(cells, "ColumnWidth", new Variant(columnWidth));
	}
	
	/**
	 * ����ѡ�е�Ԫ��Ŀ��
	 * @param width
	 */
	public void setCellWidth(Integer preferredWidthType, double preferredWidth) {
		Dispatch cells = Dispatch.get(selection, "Cells").toDispatch();
		Dispatch.put(cells, "PreferredWidthType", new Variant(preferredWidthType));
		Dispatch.put(cells, "PreferredWidth", new Variant(preferredWidth));
	}
	
	
	/**
	 * ���ñ��߿�
	 * @param tableIndex
	 * @param insideLineStyle
	 * @param outsideLineStyle
	 */
	public void setTableBorders(int tableIndex, int insideLineStyle, int outsideLineStyle) {
		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
				.toDispatch();
		Dispatch borders = Dispatch.get(table, "Borders").toDispatch();
		Dispatch.put(borders, "InsideLineStyle", new Variant(insideLineStyle));
		Dispatch.put(borders, "OutsideLineStyle", new Variant(outsideLineStyle));
	}

	/**
	 * 
	 * ���õ�ǰ�ĵ������б��ˮƽ���з�ʽ������һЩ��ʽ,���ڽ�word�ļ�ת��Ϊhtml��,����걨��
	 */

	public void setApplyTableFormat() {

		Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();

		int tabCount = Integer.valueOf(Dispatch.get(tables, "Count").toString()); 

		for (int i = 1; i <= tabCount; i++) {

			Dispatch table = Dispatch.call(tables, "Item", new Variant(i))
					.toDispatch();

			Dispatch rows = Dispatch.get(table, "Rows").toDispatch();

			Dispatch.put(rows, "Alignment", new Variant(1)); // 1-����

			Dispatch.call(table, "AutoFitBehavior", new Variant(0));

			Dispatch.put(table, "PreferredWidthType", new Variant(2));

			Dispatch.put(table, "PreferredWidth", new Variant(100));

			//System.out.println(Dispatch.get(rows, "HeightRule").toString());

			Dispatch.put(rows, "HeightRule", new Variant(0)); // 0-�Զ�wdRowHeightAuto,1-��СֵwdRowHeightAtLeast,
																// 2-�̶�wdRowHeightExactly

			//Dispatch.put(rows, "Height", new Variant(0.04 * 28.35));
		}

	}

	/**
	 * 
	 * ���ö����ʽ
	 * 
	 * 
	 * 
	 * @param alignment
	 * 
	 *            0-�����, 1-�Ҷ���, 2-�Ҷ���, 3-���˶���, 4-��ɢ����
	 * 
	 * @param lineSpacingRule
	 * 
	 * @param lineUnitBefore
	 * 
	 * @param lineUnitAfter
	 * 
	 * @param characterUnitFirstLineIndent
	 */

	public void setParagraphsProperties(int alignment, int lineSpacingRule,
			double lineSpacing, int lineUnitBefore, int lineUnitAfter,
			int characterUnitFirstLineIndent) {

		Dispatch paragraphs = Dispatch.get(selection, "Paragraphs")
				.toDispatch();

		Dispatch.put(paragraphs, "Alignment", new Variant(alignment)); // ���뷽ʽ

		Dispatch.put(paragraphs, "LineSpacingRule",
				new Variant(lineSpacingRule)); // �о�

		if (lineSpacingRule > 2) {
			Dispatch.put(paragraphs, "LineSpacing", new Variant(lineSpacing));
		}

		Dispatch.put(paragraphs, "LineUnitBefore", new Variant(lineUnitBefore)); // ��ǰ

		Dispatch.put(paragraphs, "LineUnitAfter", new Variant(lineUnitAfter)); // �κ�

		Dispatch.put(paragraphs, "CharacterUnitFirstLineIndent",

		new Variant(characterUnitFirstLineIndent)); // ���������ַ���

	}

	/**
	 * 
	 * ��ӡ��ǰ�����ʽ, ʹ��ǰ,����ѡ�ж���
	 */

	public void getParagraphsProperties() {

		Dispatch paragraphs = Dispatch.get(selection, "Paragraphs")
				.toDispatch();

		String val = Dispatch.get(paragraphs, "LineSpacingRule").toString(); // �о�

		System.out.println("�о�:" + val);

		val = Dispatch.get(paragraphs, "Alignment").toString(); // ���뷽ʽ

		System.out.println("���뷽ʽ:" + val); // 0-�����, 1-�Ҷ���, 2-�Ҷ���, 3-���˶���,
											// 4-��ɢ����

		val = Dispatch.get(paragraphs, "LineUnitBefore").toString(); // ��ǰ����

		System.out.println("��ǰ����:" + val);

		val = Dispatch.get(paragraphs, "LineUnitAfter").toString(); // �κ�����

		System.out.println("�κ�����:" + val);

		val = Dispatch.get(paragraphs, "FirstLineIndent").toString(); // ��������

		System.out.println("��������:" + val);

		val = Dispatch.get(paragraphs, "CharacterUnitFirstLineIndent")
				.toString(); // ���������ַ���

		System.out.println("���������ַ���:" + val);

	}

	/**
	 * 
	 * �ļ���������Ϊ
	 * 
	 * 
	 * 
	 * @param savePath
	 * 
	 *            ��������Ϊ·��
	 */

	public void save(String savePath) {

		/*Dispatch.call(Dispatch.call(word, "WordBasic").getDispatch(),

		"SaveAs", savePath);*/
		Dispatch.invoke(doc, "SaveAs", Dispatch.Method,

				new Object[] { savePath, new Variant(0) }, new int[1]);

	}

	/**
	 * 
	 * �ļ�����Ϊhtml��ʽ
	 * 
	 * 
	 * 
	 * @param savePath
	 * 
	 * @param htmlPath
	 */

	public void saveAsHtml(String htmlPath) {

		Dispatch.invoke(doc, "SaveAs", Dispatch.Method,

		new Object[] { htmlPath, new Variant(8) }, new int[1]);

	}

	/**
	 * 
	 * �ر��ĵ�
	 * 
	 * @param val
	 *            0�������޸� -1 �����޸� -2 ��ʾ�Ƿ񱣴��޸�
	 */

	public void closeDocument(int val) {

		Dispatch.call(doc, "Close", new Variant(val));

		doc = null;

	}

	/**
	 * 
	 * �رյ�ǰword�ĵ�
	 * 
	 * 
	 */

	public void closeDocument() {

		if (doc != null) {

			Dispatch.call(doc, "Save");

			Dispatch.call(doc, "Close", new Variant(saveOnExit));

			doc = null;

		}

	}

	public void closeDocumentWithoutSave() {

		if (doc != null) {

			Dispatch.call(doc, "Close", new Variant(false));

			doc = null;

		}

	}

	/**
	 * 
	 * �ر�ȫ��Ӧ��
	 * 
	 * 
	 */

	public void close() {

		// closeDocument();
		if (word != null) {
			/*Dispatch template = word.getProperty("NormalTemplate").toDispatch();
			//�ж��Ƿ񱣴�ģ��
			boolean  saved = Dispatch.get(template,"Saved").getBoolean();
			if(!saved){
				//����ģ��
				Dispatch.put(template, "Saved", true);
			}*/

			Dispatch.call(word, "Quit", new Variant(0));

			word = null;

		}

		selection = null;

		documents = null;

		ComThread.Release();// �ͷ�com�̡߳�����jacob�İ����ĵ���com���̻߳��ղ���java����������������

	}

	/**
	 * 
	 * ��ӡ��ǰword�ĵ�
	 * 
	 * 
	 */

	public void printFile() {

		if (doc != null) {

			Dispatch.call(doc, "PrintOut");

		}

	}

	/**
	 * 
	 * ������ǰ��,���������, ʹ��expression.Protect(Type, NoReset, Password)
	 * 
	 * 
	 * 
	 * @param pwd
	 * 
	 *            WdProtectionType ���������� WdProtectionType ����֮һ��
	 * 
	 *            1-wdAllowOnlyComments, 2-wdAllowOnlyFormFields,
	 *            0-wdAllowOnlyRevisions,
	 * 
	 *            -1-wdNoProtection, 3-wdAllowOnlyReading
	 * 
	 * 
	 */

	public void protectedWord(String pwd) {

		String protectionType = Dispatch.get(doc, "ProtectionType").toString();

		if (protectionType.equals("-1")) {

			Dispatch.call(doc, "Protect", new Variant(3), new Variant(true),
					pwd);

		}

	}

	/**
	 * 
	 * ����ĵ�����,�������
	 * 
	 * @param pwd
	 * 
	 *            WdProtectionType ����֮һ(Long ���ͣ�ֻ��)��
	 * 
	 *            1-wdAllowOnlyComments,2-wdAllowOnlyFormFields��
	 * 
	 *            0-wdAllowOnlyRevisions,-1-wdNoProtection, 3-wdAllowOnlyReading
	 * 
	 * 
	 */

	public void unProtectedWord(String pwd) {

		String protectionType = Dispatch.get(doc, "ProtectionType").toString();

		if (protectionType.equals("3")) {

			Dispatch.call(doc, "Unprotect", pwd);

		}

	}

	/**
	 * 
	 * ����word�ĵ���ȫ����
	 * 
	 * @param value
	 * 
	 *            1-msoAutomationSecurityByUI ʹ�á���ȫ���Ի���ָ���İ�ȫ���á�
	 * 
	 *            2-msoAutomationSecurityForceDisable
	 *            �ڳ���򿪵������ļ��н������к꣬������ʾ�κΰ�ȫ���ѡ�
	 * 
	 *            3-msoAutomationSecurityLow �������к꣬��������Ӧ�ó���ʱ��Ĭ��ֵ��
	 */

	public void setAutomationSecurity(int value) {

		word.setProperty("AutomationSecurity", new Variant(value));

	}

	/**
	 * 
	 * ��ȡ�ĵ��е�paragraphsIndex�����ֵ�����;
	 * 
	 * @param paragraphsIndex
	 * 
	 * @return
	 */

	public String getParagraphs(int paragraphsIndex) {

		String ret = "";

		Dispatch paragraphs = Dispatch.get(doc, "Paragraphs").toDispatch(); // ���ж���

		int paragraphCount = Dispatch.get(paragraphs, "Count").getInt(); // һ���Ķ�����

		Dispatch paragraph = null;

		Dispatch range = null;

		if (paragraphCount > paragraphsIndex && 0 < paragraphsIndex) {

			paragraph = Dispatch.call(paragraphs, "Item",
					new Variant(paragraphsIndex)).toDispatch();

			range = Dispatch.get(paragraph, "Range").toDispatch();

			ret = Dispatch.get(range, "Text").toString();

		}

		return ret;

	}

	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * WordBean word = new WordBean();
	 * 
	 * word.createNewDocument();
	 * 
	 * word.createTable("", 5, 5);
	 * 
	 * word.mergeCell(1, 1, 1, 1, 5);
	 * 
	 * word.mergeCell(1, 2, 1, 2, 5);
	 * 
	 * word.mergeCell(1, 3, 1, 3, 5);
	 * 
	 * word.putTxtToCell(1, 1, 1, "����");
	 * 
	 * word.putTxtToCell(1, 2, 1, "ʱ��");
	 * 
	 * word.putTxtToCell(1, 3, 1, "��Ա");
	 * 
	 * word.putTxtToCell(1, 4, 2, "˵����");
	 * 
	 * word.save("c:\\jacobTest.doc");
	 * 
	 * System.out.print("���c:\\jacobTest.doc�鿴�Ƿ���дword�ɹ�!");
	 * 
	 * word.close();
	 * 
	 * }
	 */

}