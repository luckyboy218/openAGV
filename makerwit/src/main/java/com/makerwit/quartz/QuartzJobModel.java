package com.makerwit.quartz;

/**
 * 定时任务对象
 *
 * @author Laotang
 * /
 /* **
 Cron表达式规则格式

 s M h d m w [y]
 s:seconds,取值0-59,允许- * /;

 M:minutes,取值0-59,允许- * /;

 h:hour,取值0-23,允许- * /;

 d:day of month,取值1-31,允许- * ? / L W;

 m:month,取值1-12/JAN-DEC,允许- * /;

 w:day of week,取值1-7/SUN-SAT,允许- * ? / L #;

 y:year,可选,取值empty、1970-2099,允许- * /;

 符号解释
 、 指定枚举值,如在秒字段使用10、12,则表示只有第10秒和第12秒执行
 - 指定区间范围,配合使用,如在小时字段使用10-12,表示在10、11、12时都会触发

 * 代表所有值,单独使用,如在秒字段使用,表示每秒触发

 ? 代表不确定值,单独使用,不用关心的值

 / 用于递增触发,配合使用,n/m,从n开始,每次增加m,如在秒字段设置5/15,表示从第5秒开始,每15秒触发一次

 L 表示最后,单独使用,如在秒字段使用,代表第59秒触发,如果在前面加上数字,则表示该数据的最后一个,如在周字段使用6L,则表示本月最后一个周五
 W 表示最近的工作日,不会跨月,比如30W，30号是周六，则不会顺延至下周一来执行,如在月字段使用15W,则表示到本月15日最近的工作日(周一到周五)
 # 用来指定x的第n个工作日,如在周字段使用6#3则表示该月的第三个星期五

 月取值
 一月:JAN/0
 二月:FEB/1
 三月:MAR/2
 四月:APR/3
 五月:MAY/4
 六月:JUN/5
 七月:JUL/6
 八月:AUG/7
 九月:SEP/8
 十月:OCT/9
 十一月:NOV/10
 十二月:DEC/11

 周取值
 周日:SUN/1
 周一:MON/2
 周二:TUE/3
 周三:WED/4
 周四:THU/5
 周五:FRI/6
 周六:SAT/7

 示例
 0/20 * * * * ? 每20秒执行一次
 1-30 * * * * ? 在1-30秒执行
 15 0/2 * * * ? 偶数分钟的第15秒执行
 0 0/2 8-17 * * ? 从8时到17时 ,每个偶数分钟执行一次
 0 0/3 17-23 * * ? 从17时到23时,每3分钟运行一次
 0 0 10am 1,15 * ? 每个月的1号和15号的上午10点 运行
 0,30 * * ? * MON-FRI 周一至周五,每30秒运行一次
 0,30 * * ? * SAT,SUN 周六、周日,每30秒运行一次
 0 0 12 * * ? 每天12点触发
 0 15 10 ? * * 每天10点15分触发
 0 15 10 * * ? 每天10点15分触发
 0 15 10 * * ? * 每天10点15分触发
 0 15 10 * * ? 2005 2005年每天10点15分触发
 0 * 14 * * ? 每天下午的 2点到2点59分每分触发
 0 0/5 14 * * ? 每天下午的 2点到2点59分(整点开始，每隔5分触发)
 0 0/5 14,18 * * ? 每天下午的 2点到2点59分(整点开始，每隔5分触发) 每天下午的 18点到18点59分(整点开始，每隔5分触发)
 0 0-5 14 * * ?  每天下午的 2点到2点05分每分触发
 0 10,44 14 ? 3 WED 3月分每周三下午的 2点10分和2点44分触发
 0 15 10 ? * MON-FRI 从周一到周五每天上午的10点15分触发
 0 15 10 15 * ? 每月15号上午10点15分触发
 0 15 10 L * ? 每月最后一天的10点15分触发
 0 15 10 ? * 6L 每月最后一周的星期五的10点15分触发
 0 15 10 ? * 6L 2002-2005 从2002年到2005年每月最后一周的星期五的10点15分触发
 0 15 10 ? * 6#3 每月的第三周的星期五开始触发
 0 0 12 1/5 * ? 每月的第一个中午开始每隔5天触发一次
 0 11 11 11 11 ? 每年的11月11号 11点11分触发(光棍节)
 */
public class QuartzJobModel {

    // 任务类
    private Class jobClass;
     // cron表达式
    private String cronExpression;

    public QuartzJobModel(Class jobClass, String cronExpression) {
        this.jobClass = jobClass;
        this.cronExpression = cronExpression;
    }

    public Class getJobClass() {
        return jobClass;
    }

    public String getCronExpression() {
        return cronExpression;
    }

}
