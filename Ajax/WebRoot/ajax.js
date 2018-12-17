/**
 * @author ����
 * @param json�����������4����ֵ�ԣ��ֱ��ǣ�
 * 		1.url 
 * 		2.type -- get ���� post 
 * 		3.data -- ǰ�˸���˴��ݵĲ���(ǰ�˴��ݵ�ʱ��,��"����"����ʽ) 
 * 		4.�ص����� -- success 
 * 		5.�ص����� -- error
 * ���磺
 * 		$.ajax({
  				url:"ajax.do",
  				type:"get",
  				data:{
  					username:val,
  					password:123456
  				},
  				success:function(data){
  					alert(data);
  				},
  				error:function(error){
  					alert(error);
  				}
  			});
  		ע�⣺
  			1�����е�key������Ҫ��˫���ţ�
  			2��data�����ǵ�ֵ��һ��json��������ŵ�����ֻҪ����json�﷨��������ţ�
  			3��success�ص��������棬��������������͵�����ͨ��Ϣһ��Ҫ����msg��ʶ���������������ᱻĬ��Ϊjson�ַ�����
  			4��success�ص��������棬����������Ĳ���msg�Ļ�������json�ַ������ڸûص����棬�Ѿ�Ĭ�ϰѸ�json�ַ���ת����json����
  			��������ʹ�ø�data��ʱ��һ��Ҫע�����ͣ�
  			5��success��error�ص������У�data��error�ֱ�Ϊ��̨���ͻ��������ݼ�������Ϣ��
  		����ϸ�鿴Դ���룡����������������Ҫ���ã�����㲻���ã��ǻ�������ʵʵȥʹ��ԭ��̬��ajax�ɣ�
  		@��Ȩ���� ��������1809�࣡
 */
function $ajax(obj) {
	// �����������ʱ��,������"����"����ʽ���ݽ���
	// �涨: obj��һ��json���������������:
	
	//��ȡ��ajax����
	var ajaxObj = null;
	if (window.XMLHttpRequest) {
		ajaxObj = new XMLHttpRequest();
	} else {
		ajaxObj = new ActiveObject("Microsoft.XMLHTTP");
	}
	// ���״̬�ı仯
	ajaxObj.onreadystatechange = function() {
		if (ajaxObj.readyState == 4) {
			if (ajaxObj.status >= 200 && ajaxObj.status < 300
					|| ajaxObj.status == 304) {
				//�ɹ���ȡ����̨������������ݲ��Ұ󶨵�success��
				if (obj.success) {
					//�������ͨ����Ϣ�����������ϼ�һ��msg��ʶ��
					if(ajaxObj.responseText.indexOf("msg")>=0){
						obj.success(ajaxObj.responseText);
					//�����json����Ϣ������Ҫ�κβ���
					}else{
						//����success�ص����������ҰѺ�̨�����������ݽ���json����
						obj.success(JSON.parse(ajaxObj.responseText));
					}
				} else {
					alert("�������� success ����");
				}
			} else {
				if (obj.error) {
					obj.error(ajaxObj.status);
				} else {
					alert("�������� error ����");
				}
			}
		}
	}
	//���ûдtype��Ĭ��Ϊget
	var type = obj.type || "get";
	// type ת��ΪСд
	type = type.toLowerCase();
	// �ж��Ƿ񴫵��˲���
	//����һ��params����
	var params = "";
	//�������Ƕ���ĸ�ʽ�������㴫��Ĳ������������֮���ٽ����ַ�����ƴ��
	if (obj.data) {
		for ( var key in obj.data) {
			params += (key + "=" + obj.data[key] + "&");
		}
		//�����ַ�������&����
		params = params.slice(0, params.length - 1);
	}
	//�ж����������get�Ļ�������ajax��get��ʽ������
	if (type == "get") {
		ajaxObj.open(type, obj.url + "?" + params, true);
		ajaxObj.send(null);
	//�ж����������post�Ļ�������ajax��post��ʽ������
	} else {
		ajaxObj.open(type, obj.url, true);
		ajaxObj.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		ajaxObj.send(params);
	}
}