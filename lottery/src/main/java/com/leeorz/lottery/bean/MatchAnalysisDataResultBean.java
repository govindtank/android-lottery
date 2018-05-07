package com.leeorz.lottery.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/26 下午7:43
 * description:
 */
public class MatchAnalysisDataResultBean {


    /**
     * type : 0
     * title :
     * lid : 63
     * sid : 4453
     * stid : 12799
     * iscup : 1
     * lname : 欧罗巴
     * rid : 0
     * roundtype : bout
     * hname : 马赛
     * aname : 萨茨堡
     * ranks : [{"homestanding":{"lname":"法甲","name":"马赛","standing":"4","score":"69","win":"20","draw":"9","lost":"5","innum":"72","lostnum":"41","count":"34"},"awaystanding":{"lname":"奥甲","name":"萨茨堡","standing":"1","score":"71","win":"21","draw":"8","lost":"2","innum":"70","lostnum":"23","count":"31"},"title":"联赛积分排名","type":"4"}]
     * hpower : {"worth_score":"70","attack_score":"89","defend_score":"71","tech_score":"69","state_score":"74","worth_capability":"7","attack_capability":"9","defend_capability":"7","tech_capability":"7","state_capability":"7","grade":"3","updatetime":"2018-04-22 00:54:23","total_score":"373"}
     * apower : {"worth_score":"60","attack_score":"66","defend_score":"57","tech_score":"61","state_score":"56","worth_capability":"6","attack_capability":"7","defend_capability":"6","tech_capability":"6","state_capability":"6","grade":"3","updatetime":"2018-04-22 22:40:14","total_score":"300"}
     * all : []
     * single : []
     * fuck_datadetail : [{"fid":"698516","league":"欧罗巴","date":"17-12-08","score":"0-0","home":"马  赛","away":"萨茨堡","homeid":"1064","awayid":"446","result":"平","handi":"-0.5/1","pl":"输","bs":"小"},{"fid":"698508","league":"欧罗巴","date":"17-09-29","score":"1-0","home":"萨茨堡","away":"马  赛","homeid":"446","awayid":"1064","result":"负","handi":"-0/0.5","pl":"输","bs":"小"}]
     * fuck_datatotal : {"lostrate":"50%","drawrate":"50%","winrate":"0%","small":"2","big":"0","lostnum":"1","innum":"0","lost":"1","draw":"1","win":"0","count":"2"}
     * home_datadetail : [{"fid":"665059","league":"法甲","date":"18-04-21","score":"5-1","home":"马  赛","away":"里  尔","homeid":"1064","awayid":"998","result":"胜","handi":"-1.5","pl":"赢","bs":"大"},{"fid":"665054","league":"法甲","date":"18-04-15","score":"2-3","home":"特鲁瓦","away":"马  赛","homeid":"1225","awayid":"1064","result":"胜","handi":"1","pl":"走","bs":"大"},{"fid":"723079","league":"欧罗巴","date":"18-04-13","score":"5-2","home":"马  赛","away":"莱比锡","homeid":"1064","awayid":"970","result":"胜","handi":"-0/0.5","pl":"赢","bs":"大"},{"fid":"665039","league":"法甲","date":"18-04-09","score":"0-0","home":"马  赛","away":"蒙彼利","homeid":"1064","awayid":"1090","result":"平","handi":"-0.5","pl":"输","bs":"小"},{"fid":"723075","league":"欧罗巴","date":"18-04-06","score":"1-0","home":"莱比锡","away":"马  赛","homeid":"970","awayid":"1064","result":"负","handi":"-1","pl":"走","bs":"小"},{"fid":"665026","league":"法甲","date":"18-03-31","score":"1-3","home":"第  戎","away":"马  赛","homeid":"774","awayid":"1064","result":"胜","handi":"0.5/1","pl":"赢","bs":"大"},{"fid":"665018","league":"法甲","date":"18-03-19","score":"2-3","home":"马  赛","away":"里  昂","homeid":"1064","awayid":"997","result":"负","handi":"-0.5","pl":"输","bs":"大"},{"fid":"719656","league":"欧罗巴","date":"18-03-16","score":"1-2","home":"毕尔巴","away":"马  赛","homeid":"690","awayid":"1064","result":"胜","handi":"-0/0.5","pl":"赢","bs":"大"},{"fid":"665014","league":"法甲","date":"18-03-12","score":"1-2","home":"图卢兹","away":"马  赛","homeid":"1233","awayid":"1064","result":"胜","handi":"0.5","pl":"赢","bs":"大"},{"fid":"719652","league":"欧罗巴","date":"18-03-09","score":"3-1","home":"马  赛","away":"毕尔巴","homeid":"1064","awayid":"690","result":"胜","handi":"-0.5/1","pl":"赢","bs":"大"}]
     * home_datatotal : {"lostrate":"20%","drawrate":"10%","winrate":"70%","lostnum":"13","innum":"25","lost":"2","draw":"1","win":"7","count":"10","big":"8","small":"2"}
     * home_desc :
     * away_datadetail : [{"fid":"669502","league":"奥甲","date":"18-04-22","score":"3-1","home":"萨茨堡","away":"阿尔特","homeid":"446","awayid":"1788","result":"胜","handi":"-1.5/2","pl":"赢","bs":"大"},{"fid":"726179","league":"奥地利杯","date":"18-04-18","score":"0-0","home":"马特斯","away":"萨茨堡","homeid":"1828","awayid":"446","result":"平","handi":"1","pl":"输","bs":"小"},{"fid":"669494","league":"奥甲","date":"18-04-16","score":"2-6","home":"阿德米","away":"萨茨堡","homeid":"586","awayid":"446","result":"胜","handi":"1/1.5","pl":"赢","bs":"大"},{"fid":"723082","league":"欧罗巴","date":"18-04-13","score":"4-1","home":"萨茨堡","away":"拉齐奥","homeid":"446","awayid":"964","result":"胜","handi":"-0/0.5","pl":"赢","bs":"大"},{"fid":"669518","league":"奥甲","date":"18-04-08","score":"1-0","home":"LA林茨","away":"萨茨堡","homeid":"334","awayid":"446","result":"负","handi":"0/0.5","pl":"输","bs":"小"},{"fid":"723078","league":"欧罗巴","date":"18-04-06","score":"4-2","home":"拉齐奥","away":"萨茨堡","homeid":"964","awayid":"446","result":"负","handi":"-0.5","pl":"输","bs":"大"},{"fid":"669491","league":"奥甲","date":"18-04-01","score":"2-0","home":"萨茨堡","away":"沃尔贝","homeid":"446","awayid":"3100","result":"胜","handi":"","pl":"","bs":"小"},{"fid":"669484","league":"奥甲","date":"18-03-18","score":"5-0","home":"萨茨堡","away":"维也纳","homeid":"446","awayid":"603","result":"胜","handi":"-1/1.5","pl":"赢","bs":"大"},{"fid":"719658","league":"欧罗巴","date":"18-03-16","score":"0-0","home":"萨茨堡","away":"多  特","homeid":"446","awayid":"786","result":"平","handi":"0/0.5","pl":"赢","bs":"小"},{"fid":"669480","league":"奥甲","date":"18-03-11","score":"2-2","home":"马特斯","away":"萨茨堡","homeid":"1828","awayid":"446","result":"平","handi":"0.5/1","pl":"输","bs":"大"}]
     * away_datatotal : {"lostrate":"20%","drawrate":"30%","winrate":"50%","lostnum":"11","innum":"24","lost":"2","draw":"3","win":"5","count":"10","big":"6","small":"4"}
     * away_desc :
     * content : ["2天后，马赛将在法国甲级联赛中客场挑战昂热","3天后，萨尔茨堡将在奥地利甲级联赛中客场挑战圣珀尔滕","马赛今届欧霸盃主场优势明显，其中他们上仗欧霸就凭藉主场之利取得大胜逆转晋级，马赛是役主场值得看高一线。"]
     */

    private String type;
    private String title;
    private String lid;
    private String sid;
    private String stid;
    private String iscup;
    private String lname;
    private String rid;
    private String roundtype;
    private String hname;
    private String aname;
    private TotalBean fuck_datatotal;
    private TotalBean home_datatotal;
    private String home_desc;
    private TotalBean away_datatotal;
    private String away_desc;
    private List<RanksBean> ranks;
    private List<?> all;
    private List<?> single;
    private List<HistoryDetailBean> fuck_datadetail;
    private List<HistoryDetailBean> home_datadetail;
    private List<HistoryDetailBean> away_datadetail;
    private List<String> content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid;
    }

    public String getIscup() {
        return iscup;
    }

    public void setIscup(String iscup) {
        this.iscup = iscup;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRoundtype() {
        return roundtype;
    }

    public void setRoundtype(String roundtype) {
        this.roundtype = roundtype;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }



    public TotalBean getFuck_datatotal() {
        return fuck_datatotal;
    }

    public void setFuck_datatotal(TotalBean fuck_datatotal) {
        this.fuck_datatotal = fuck_datatotal;
    }

    public TotalBean getHome_datatotal() {
        return home_datatotal;
    }

    public void setHome_datatotal(TotalBean home_datatotal) {
        this.home_datatotal = home_datatotal;
    }

    public String getHome_desc() {
        return home_desc;
    }

    public void setHome_desc(String home_desc) {
        this.home_desc = home_desc;
    }

    public TotalBean getAway_datatotal() {
        return away_datatotal;
    }

    public void setAway_datatotal(TotalBean away_datatotal) {
        this.away_datatotal = away_datatotal;
    }

    public String getAway_desc() {
        return away_desc;
    }

    public void setAway_desc(String away_desc) {
        this.away_desc = away_desc;
    }

    public List<RanksBean> getRanks() {
        return ranks;
    }

    public void setRanks(List<RanksBean> ranks) {
        this.ranks = ranks;
    }

    public List<?> getAll() {
        return all;
    }

    public void setAll(List<?> all) {
        this.all = all;
    }

    public List<?> getSingle() {
        return single;
    }

    public void setSingle(List<?> single) {
        this.single = single;
    }

    public List<HistoryDetailBean> getFuck_datadetail() {
        return fuck_datadetail;
    }

    public void setFuck_datadetail(List<HistoryDetailBean> fuck_datadetail) {
        this.fuck_datadetail = fuck_datadetail;
    }

    public List<HistoryDetailBean> getHome_datadetail() {
        return home_datadetail;
    }

    public void setHome_datadetail(List<HistoryDetailBean> home_datadetail) {
        this.home_datadetail = home_datadetail;
    }

    public List<HistoryDetailBean> getAway_datadetail() {
        return away_datadetail;
    }

    public void setAway_datadetail(List<HistoryDetailBean> away_datadetail) {
        this.away_datadetail = away_datadetail;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public static class HpowerBean {
        /**
         * worth_score : 70
         * attack_score : 89
         * defend_score : 71
         * tech_score : 69
         * state_score : 74
         * worth_capability : 7
         * attack_capability : 9
         * defend_capability : 7
         * tech_capability : 7
         * state_capability : 7
         * grade : 3
         * updatetime : 2018-04-22 00:54:23
         * total_score : 373
         */

        private String worth_score;
        private String attack_score;
        private String defend_score;
        private String tech_score;
        private String state_score;
        private String worth_capability;
        private String attack_capability;
        private String defend_capability;
        private String tech_capability;
        private String state_capability;
        private String grade;
        private String updatetime;
        private String total_score;

        public String getWorth_score() {
            return worth_score;
        }

        public void setWorth_score(String worth_score) {
            this.worth_score = worth_score;
        }

        public String getAttack_score() {
            return attack_score;
        }

        public void setAttack_score(String attack_score) {
            this.attack_score = attack_score;
        }

        public String getDefend_score() {
            return defend_score;
        }

        public void setDefend_score(String defend_score) {
            this.defend_score = defend_score;
        }

        public String getTech_score() {
            return tech_score;
        }

        public void setTech_score(String tech_score) {
            this.tech_score = tech_score;
        }

        public String getState_score() {
            return state_score;
        }

        public void setState_score(String state_score) {
            this.state_score = state_score;
        }

        public String getWorth_capability() {
            return worth_capability;
        }

        public void setWorth_capability(String worth_capability) {
            this.worth_capability = worth_capability;
        }

        public String getAttack_capability() {
            return attack_capability;
        }

        public void setAttack_capability(String attack_capability) {
            this.attack_capability = attack_capability;
        }

        public String getDefend_capability() {
            return defend_capability;
        }

        public void setDefend_capability(String defend_capability) {
            this.defend_capability = defend_capability;
        }

        public String getTech_capability() {
            return tech_capability;
        }

        public void setTech_capability(String tech_capability) {
            this.tech_capability = tech_capability;
        }

        public String getState_capability() {
            return state_capability;
        }

        public void setState_capability(String state_capability) {
            this.state_capability = state_capability;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getTotal_score() {
            return total_score;
        }

        public void setTotal_score(String total_score) {
            this.total_score = total_score;
        }
    }

    public static class ApowerBean {
        /**
         * worth_score : 60
         * attack_score : 66
         * defend_score : 57
         * tech_score : 61
         * state_score : 56
         * worth_capability : 6
         * attack_capability : 7
         * defend_capability : 6
         * tech_capability : 6
         * state_capability : 6
         * grade : 3
         * updatetime : 2018-04-22 22:40:14
         * total_score : 300
         */

        private String worth_score;
        private String attack_score;
        private String defend_score;
        private String tech_score;
        private String state_score;
        private String worth_capability;
        private String attack_capability;
        private String defend_capability;
        private String tech_capability;
        private String state_capability;
        private String grade;
        private String updatetime;
        private String total_score;

        public String getWorth_score() {
            return worth_score;
        }

        public void setWorth_score(String worth_score) {
            this.worth_score = worth_score;
        }

        public String getAttack_score() {
            return attack_score;
        }

        public void setAttack_score(String attack_score) {
            this.attack_score = attack_score;
        }

        public String getDefend_score() {
            return defend_score;
        }

        public void setDefend_score(String defend_score) {
            this.defend_score = defend_score;
        }

        public String getTech_score() {
            return tech_score;
        }

        public void setTech_score(String tech_score) {
            this.tech_score = tech_score;
        }

        public String getState_score() {
            return state_score;
        }

        public void setState_score(String state_score) {
            this.state_score = state_score;
        }

        public String getWorth_capability() {
            return worth_capability;
        }

        public void setWorth_capability(String worth_capability) {
            this.worth_capability = worth_capability;
        }

        public String getAttack_capability() {
            return attack_capability;
        }

        public void setAttack_capability(String attack_capability) {
            this.attack_capability = attack_capability;
        }

        public String getDefend_capability() {
            return defend_capability;
        }

        public void setDefend_capability(String defend_capability) {
            this.defend_capability = defend_capability;
        }

        public String getTech_capability() {
            return tech_capability;
        }

        public void setTech_capability(String tech_capability) {
            this.tech_capability = tech_capability;
        }

        public String getState_capability() {
            return state_capability;
        }

        public void setState_capability(String state_capability) {
            this.state_capability = state_capability;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getTotal_score() {
            return total_score;
        }

        public void setTotal_score(String total_score) {
            this.total_score = total_score;
        }
    }

    public static class FuckDatatotalBean {
        /**
         * lostrate : 50%
         * drawrate : 50%
         * winrate : 0%
         * small : 2
         * big : 0
         * lostnum : 1
         * innum : 0
         * lost : 1
         * draw : 1
         * win : 0
         * count : 2
         */

        private String lostrate;
        private String drawrate;
        private String winrate;
        private String small;
        private String big;
        private String lostnum;
        private String innum;
        private String lost;
        private String draw;
        private String win;
        private String count;

        public String getLostrate() {
            return lostrate;
        }

        public void setLostrate(String lostrate) {
            this.lostrate = lostrate;
        }

        public String getDrawrate() {
            return drawrate;
        }

        public void setDrawrate(String drawrate) {
            this.drawrate = drawrate;
        }

        public String getWinrate() {
            return winrate;
        }

        public void setWinrate(String winrate) {
            this.winrate = winrate;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getBig() {
            return big;
        }

        public void setBig(String big) {
            this.big = big;
        }

        public String getLostnum() {
            return lostnum;
        }

        public void setLostnum(String lostnum) {
            this.lostnum = lostnum;
        }

        public String getInnum() {
            return innum;
        }

        public void setInnum(String innum) {
            this.innum = innum;
        }

        public String getLost() {
            return lost;
        }

        public void setLost(String lost) {
            this.lost = lost;
        }

        public String getDraw() {
            return draw;
        }

        public void setDraw(String draw) {
            this.draw = draw;
        }

        public String getWin() {
            return win;
        }

        public void setWin(String win) {
            this.win = win;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }
    }

    public static class TotalBean {
        /**
         * lostrate : 20%
         * drawrate : 10%
         * winrate : 70%
         * lostnum : 13
         * innum : 25
         * lost : 2
         * draw : 1
         * win : 7
         * count : 10
         * big : 8
         * small : 2
         */

        private String lostrate;
        private String drawrate;
        private String winrate;
        private String lostnum;
        private String innum;
        private String lost;
        private String draw;
        private String win;
        private String count;
        private String big;
        private String small;

        public String getLostrate() {
            return lostrate;
        }

        public void setLostrate(String lostrate) {
            this.lostrate = lostrate;
        }

        public String getDrawrate() {
            return drawrate;
        }

        public void setDrawrate(String drawrate) {
            this.drawrate = drawrate;
        }

        public String getWinrate() {
            return winrate;
        }

        public void setWinrate(String winrate) {
            this.winrate = winrate;
        }

        public String getLostnum() {
            return lostnum;
        }

        public void setLostnum(String lostnum) {
            this.lostnum = lostnum;
        }

        public String getInnum() {
            return innum;
        }

        public void setInnum(String innum) {
            this.innum = innum;
        }

        public String getLost() {
            return lost;
        }

        public void setLost(String lost) {
            this.lost = lost;
        }

        public String getDraw() {
            return draw;
        }

        public void setDraw(String draw) {
            this.draw = draw;
        }

        public String getWin() {
            return win;
        }

        public void setWin(String win) {
            this.win = win;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getBig() {
            return big;
        }

        public void setBig(String big) {
            this.big = big;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }
    }

    public static class RanksBean {
        /**
         * homestanding : {"lname":"法甲","name":"马赛","standing":"4","score":"69","win":"20","draw":"9","lost":"5","innum":"72","lostnum":"41","count":"34"}
         * awaystanding : {"lname":"奥甲","name":"萨茨堡","standing":"1","score":"71","win":"21","draw":"8","lost":"2","innum":"70","lostnum":"23","count":"31"}
         * title : 联赛积分排名
         * type : 4
         */
        List<RanksDetailBean> data = new ArrayList();
        private RanksDetailBean homestanding;
        private RanksDetailBean awaystanding;
        private String title;
        private String type;

        public RanksDetailBean getHomestanding() {
            return homestanding;
        }

        public void setHomestanding(RanksDetailBean homestanding) {
            this.homestanding = homestanding;
        }

        public RanksDetailBean getAwaystanding() {
            return awaystanding;
        }

        public void setAwaystanding(RanksDetailBean awaystanding) {
            this.awaystanding = awaystanding;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<RanksDetailBean> getData() {
            return data;
        }

        public void setData(List<RanksDetailBean> data) {
            this.data = data;
        }

        public static class RanksDetailBean {
            /**
             * lname : 法甲
             * name : 马赛
             * standing : 4
             * score : 69
             * win : 20
             * draw : 9
             * lost : 5
             * innum : 72
             * lostnum : 41
             * count : 34
             */

            private String lname;
            private String name;
            private String standing;
            private String score;
            private String win;
            private String draw;
            private String lost;
            private String innum;
            private String lostnum;
            private String count;

            public String getLname() {
                return lname;
            }

            public void setLname(String lname) {
                this.lname = lname;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStanding() {
                return standing;
            }

            public void setStanding(String standing) {
                this.standing = standing;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getWin() {
                return win;
            }

            public void setWin(String win) {
                this.win = win;
            }

            public String getDraw() {
                return draw;
            }

            public void setDraw(String draw) {
                this.draw = draw;
            }

            public String getLost() {
                return lost;
            }

            public void setLost(String lost) {
                this.lost = lost;
            }

            public String getInnum() {
                return innum;
            }

            public void setInnum(String innum) {
                this.innum = innum;
            }

            public String getLostnum() {
                return lostnum;
            }

            public void setLostnum(String lostnum) {
                this.lostnum = lostnum;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }
        }
    }

    public static class HistoryDetailBean {
        /**
         * fid : 698516
         * league : 欧罗巴
         * date : 17-12-08
         * score : 0-0
         * home : 马  赛
         * away : 萨茨堡
         * homeid : 1064
         * awayid : 446
         * result : 平
         * handi : -0.5/1
         * pl : 输
         * bs : 小
         */

        private String fid;
        private String league;
        private String date;
        private String score;
        private String home;
        private String away;
        private String homeid;
        private String awayid;
        private String result;
        private String handi;
        private String pl;
        private String bs;

        public String getFid() {
            return fid;
        }

        public void setFid(String fid) {
            this.fid = fid;
        }

        public String getLeague() {
            return league;
        }

        public void setLeague(String league) {
            this.league = league;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }

        public String getAway() {
            return away;
        }

        public void setAway(String away) {
            this.away = away;
        }

        public String getHomeid() {
            return homeid;
        }

        public void setHomeid(String homeid) {
            this.homeid = homeid;
        }

        public String getAwayid() {
            return awayid;
        }

        public void setAwayid(String awayid) {
            this.awayid = awayid;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getHandi() {
            return handi;
        }

        public void setHandi(String handi) {
            this.handi = handi;
        }

        public String getPl() {
            return pl;
        }

        public void setPl(String pl) {
            this.pl = pl;
        }

        public String getBs() {
            return bs;
        }

        public void setBs(String bs) {
            this.bs = bs;
        }
    }

}
