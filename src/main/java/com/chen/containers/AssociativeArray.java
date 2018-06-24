package com.chen.containers;

public class AssociativeArray<K,V> {

    private Object[][] pair;
    private int index;

    public AssociativeArray(int length){
        pair = new Object[length][2];
    }

    public void put(K key,V value){
        if(pair.length<=index)
            throw  new ArrayIndexOutOfBoundsException();
        pair[index++] = new Object[]{key,value};

    }

    public V get(K key){
        for (int i = 0; i < pair.length; i++) {
            if(pair[i][0].equals(key)){
                return (V) pair[i][1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < pair.length; i++) {
            sb.append(pair[i][0]+":"+pair[i][1]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String,String> as = new AssociativeArray<>(5);
        as.put("hubei","wuhan ");
        as.put("zhejiang","hangzhou ");
        as.put("shanxi","xian ");
        as.put("guangdong","guangzhou ");
        as.put("sichuan","chengdu ");
        try {
            as.put("yunnan","kunming ");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("unsupport");
        }
        System.out.println(as);
        String str = as.get("hubei");
        System.out.println("str:"+str);
    }
}
