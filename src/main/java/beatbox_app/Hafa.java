package beatbox_app;


public class Hafa {
	float unitPrice;// 单价
	float area;// 面积

	public static void main(String[] args) {
		new Hafa().jiChuData();
	}
	
	public void jiChuData() {
		ShuiDian shuidian = new ShuiDian();
		shuidian.shuiDianCost();
	}
	
	// 水电类：（一般包含人工＋辅料）电箱类开关插座类地漏等另计
	// 以140平房屋，4房2厅1厨2卫1阳台来估算。基本费用在13000－18000元左右.
	public class ShuiDian {
		float sdLaborCost;// 水电改造人工费
		float dianXianCost;// 电线材料费
		float shuiGuanCost;// 水管材料费
		float fuLiaoCost;// 辅料费用：包含电线管 插座的埋墙内暗盒 灯线的八角盒 一般用伟星或者中财品牌
		float xiaShuiCost;// 下水费用
		float ruoDianCost;// 弱电费用： 熊猫或者安普网线 超五类 超六类等，另电视线，电话线，音响线
		float shuiDianCostSum;// 总费用

		// 水电改造人工费
		public void sdLaborCost() {
			unitPrice = 2;
			area = 3;
			sdLaborCost = unitPrice * area;
		}

		// 电线材料费
		public void dianXianMaterials() {
			unitPrice = 0;
			area = 0;
			dianXianCost = unitPrice * area;
		}

		// 水管材料费
		public void shuiGuanMaterials() {
			unitPrice = 0;
			area = 0;
			shuiGuanCost = unitPrice * area;
		}

		// 辅料费用
		public void fuLiaoMaterials() {
			unitPrice = 0;
			area = 0;
			fuLiaoCost = unitPrice * area;
		}

		// 下水费用
		public void xiaShuiMaterials() {
			unitPrice = 0;
			area = 0;
			xiaShuiCost = unitPrice * area;
		}

		// 弱电费用
		public void ruoDianMaterials() {
			unitPrice = 1;
			area = 2;
			ruoDianCost = unitPrice * area;
		}
		
		public void shuiDianCost() {
			sdLaborCost();
			float[] shuiDianCostArray = { sdLaborCost, dianXianCost, shuiGuanCost, fuLiaoCost, xiaShuiCost, ruoDianCost };
			
			try {
				for (int i = 0; i < shuiDianCostArray.length; i++) {
					shuiDianCostSum = shuiDianCostSum + shuiDianCostArray[i];
				}
				System.out.println("水电类费用约为：" + shuiDianCostSum + "元" + sdLaborCost);
				System.out.println("其中，人工费为：" + sdLaborCost + "元； 材料费为：" + (shuiDianCostSum - sdLaborCost) + "元\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}