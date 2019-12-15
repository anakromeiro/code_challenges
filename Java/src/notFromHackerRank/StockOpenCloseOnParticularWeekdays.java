package notFromHackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.google.gson.Gson;

public class StockOpenCloseOnParticularWeekdays {

    static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {
        Map monthsNumber = new HashMap<String, String>();
        monthsNumber.put("1","January");
        monthsNumber.put("2","February");
        monthsNumber.put("3","March");
        monthsNumber.put("4","April");
        monthsNumber.put("5","May");
        monthsNumber.put("6","June");
        monthsNumber.put("7","July");
        monthsNumber.put("8","August");
        monthsNumber.put("9","September");
        monthsNumber.put("10","October");
        monthsNumber.put("11", "November");
        monthsNumber.put("12","December");

        Map weekdays = new HashMap<String, Integer>();
        weekdays.put("Monday", 2);
        weekdays.put("Tuesday", 3);
        weekdays.put("Wednesday", 4);
        weekdays.put("Thursday", 5);
        weekdays.put("Friday", 6);
        weekdays.put("Saturday", 7);
        weekdays.put("Sunday", 1);
        List<String> response = new ArrayList<String>();
        Date initialDate = parseDate(firstDate);
        Date finalDate = parseDate(lastDate);

        String firsDateSplit[] = firstDate.split("-");
        String lastDateSplit[] = lastDate.split("-");

        int yearFirstDate, yearLastDate;
        yearFirstDate = Integer.parseInt(firsDateSplit[2]);
        yearLastDate = Integer.parseInt(lastDateSplit[2]);

        int monthFirstDate = 0, monthLastDate = 0;
        Date date;
        Calendar cal;

        try {
            date = new SimpleDateFormat("MMMM", Locale.US).parse(firsDateSplit[1]);
            cal = Calendar.getInstance();
            cal.setTime(date);
            monthFirstDate = cal.get(Calendar.MONTH) + 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            date = new SimpleDateFormat("MMMM", Locale.US).parse(lastDateSplit[1]);
            cal = Calendar.getInstance();
            cal.setTime(date);
            monthLastDate = cal.get(Calendar.MONTH) + 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<StockInformation> stockInformationList = new ArrayList<>();

        try {
            if (yearLastDate - yearFirstDate == 0) {
                String searchField = "";
                searchField += yearFirstDate;

                if (monthLastDate - monthFirstDate == 0){
                    searchField = monthsNumber.get(String.valueOf(monthFirstDate)) + "-" + searchField;
                    stockInformationList.addAll(getDataFromApi(searchField));
                }else {
                    for (int i = monthFirstDate; i <= monthLastDate; i++){
                        searchField = monthsNumber.get(String.valueOf(i)) + "-" + yearFirstDate;
                        stockInformationList.addAll(getDataFromApi(searchField));

                        searchField = "";
                    }
                }

            } else if (yearLastDate - yearFirstDate > 0) {


                for (int i = monthFirstDate+1; i <= 12; i++){
                    stockInformationList.addAll(getDataFromApi(monthsNumber.get(String.valueOf(i)) + "-" + yearFirstDate));
                }

                for (int j = yearFirstDate + 1; j <= yearLastDate - 1; j++){
                    stockInformationList.addAll(getDataFromApi("" + j));
                }

                for (int i = 0;i <= monthLastDate-1; i++){
                    stockInformationList.addAll(getDataFromApi(monthsNumber.get(String.valueOf(i)) + "-" + yearLastDate));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (StockInformation s : stockInformationList){
            for (DataStockInformation d : s.getData()){

                Date currentDate = parseDate(d.getDate());

                if (currentDate.after(initialDate) && currentDate.before(finalDate)) {

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currentDate);
                    if (calendar.get(Calendar.DAY_OF_WEEK) == (int) weekdays.get(weekDay)) {
                        StringBuilder sBuilder = new StringBuilder();
                        sBuilder.append(d.getDate());
                        sBuilder.append(" ");
                        sBuilder.append(d.getOpen());
                        sBuilder.append(" ");
                        sBuilder.append(d.getClose());

                        response.add(sBuilder.toString());
                    }
                }
            }
        }
        for (String s : response) {
            System.out.println(s);
        }
    }

    public static void main(String[] args){
        openAndClosePrices("5-January-2030","1-January-2020","Wednesday");
    }

    private static Date parseDate(String date){
        Date result = null;
        try {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy", Locale.US);
        result = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    private static List<StockInformation> getDataFromApi(String param) throws IOException {
        List<StockInformation> stockList = new ArrayList<>();

        try {
            StockInformation stock = null;
            int page = 1;
            do {
                URL url = new URL("https://jsonmock.hackerrank.com/api/stocks/search?date=" + param + "&page=" + page);
                HttpURLConnection con = null;
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");

                Gson gson = new Gson();

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String inputLine = in.readLine();
                stock = gson.fromJson(inputLine, StockInformation.class);
                stockList.add(stock);
                in.close();

                page++;
            } while (stock!=null && page <= stock.getTotal_pages());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stockList;
    }

    public class StockInformation {
        private int page;
        private int per_page;
        private int total;
        private int total_pages;
        private List<DataStockInformation> data = new ArrayList<>();

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }

        public List<DataStockInformation> getData() {
            return data;
        }

        public void setData(List<DataStockInformation> data) {
            this.data = data;
        }
    }

    public class DataStockInformation {
        private String date;
        private float open;
        private float close;
        private float high;
        private float low;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public float getOpen() {
            return open;
        }

        public void setOpen(float open) {
            this.open = open;
        }

        public float getClose() {
            return close;
        }

        public void setClose(float close) {
            this.close = close;
        }

        public float getHigh() {
            return high;
        }

        public void setHigh(float high) {
            this.high = high;
        }

        public float getLow() {
            return low;
        }

        public void setLow(float low) {
            this.low = low;
        }
    }
}
