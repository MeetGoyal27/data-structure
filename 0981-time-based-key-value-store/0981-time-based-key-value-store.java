class TimeMap {
    HashMap<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).put(timestamp,value);
        }
        else{
            TreeMap<Integer,String> t = new TreeMap<>();
            t.put(timestamp,value);
            map.put(key,t);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        TreeMap<Integer,String> t = map.get(key);
        Integer time = t.floorKey(timestamp);
        if(time==null){
            return "";
        }
        return t.get(time);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */