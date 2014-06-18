package com.bingoogol.generic.test.util;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.xml.sax.InputSource;

public abstract class AbstractDbUnitTestCase {
	
	protected static IDatabaseConnection dbunitCon;
	protected File tempFile;

	/**
	 * 根据配置文件的名称创建DateSet
	 * 
	 * @param tname配置文件的名称
	 * @return
	 * @throws DataSetException
	 */
	protected IDataSet createDateSet(String tname) throws Exception {
		// 配置文件在classes的根目录下
		InputStream is = AbstractDbUnitTestCase.class.getClassLoader().getResourceAsStream(tname + ".xml");
		assertNotNull("dbunit的基本数据文件不存在", is);
		return new FlatXmlDataSet(new FlatXmlProducer(new InputSource(is)));
	}

	protected void backupAllTable() throws Exception {
		IDataSet ds = dbunitCon.createDataSet();
		writeBackupFile(ds);
	}

	protected void backupCustomTable(String[] tname) throws Exception {
		QueryDataSet ds = new QueryDataSet(dbunitCon);
		for (String str : tname) {
			ds.addTable(str);
		}
		writeBackupFile(ds);
	}

	protected void bakcupOneTable(String tname) throws Exception {
		backupCustomTable(new String[] { tname });
	}

	protected void writeBackupFile(IDataSet ds) throws Exception {
		tempFile = File.createTempFile("back", "xml");
		FlatXmlDataSet.write(ds, new FileWriter(tempFile));
		tempFile.delete();
	}

	protected void resumeTable() throws Exception {
		IDataSet ds = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(new FileInputStream(tempFile))));
		System.out.println(tempFile.getAbsolutePath());
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
	}
}
