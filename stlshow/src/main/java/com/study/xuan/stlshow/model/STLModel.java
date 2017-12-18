package com.study.xuan.stlshow.model;

import com.study.xuan.stlshow.util.STLUtils;

import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;


/**
 * Author : xuan.
 * Date : 2017/12/14.
 * Description : stl文件对应转换的3d模型数据
 */

public class STLModel {
	FloatBuffer triangleBuffer;
	FloatBuffer normalBuffer;

	public float maxX;
	public float maxY;
	public float maxZ;
	public float minX;
	public float minY;
	public float minZ;

	//优化使用的数组
	public  float[] normal_array=null;
	public  float[] vertex_array=null;
	private  int vertext_size=0;

	public void draw(GL10 gl) {
		if (triangleBuffer == null) {
			return;
		}
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);
		//gl.glFrontFace(GL10.GL_CCW);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, triangleBuffer);
		gl.glNormalPointer(GL10.GL_FLOAT,0, normalBuffer);
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vertext_size*3);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_NORMAL_ARRAY);
	}

	public void setMax(float maxX, float maxY, float maxZ) {
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
	}

	public void setMin(float minX, float minY, float minZ) {
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
	}

	public void setSize(int size) {
		this.vertext_size = size;
	}

	public void delete (){
	}

	public void setVerts(float[] verts) {
		this.vertex_array = verts;
		this.triangleBuffer = STLUtils.floatToBuffer(vertex_array);
	}

	public void setVnorms(float[] vnorms) {
		this.normal_array = vnorms;
		this.normalBuffer = STLUtils.floatToBuffer(normal_array);
	}

}