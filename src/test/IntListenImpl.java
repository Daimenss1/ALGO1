package test;

public class IntListenImpl implements Listen {

    private Integer[] storage;
    private static final int DEFAULT_CAPACITY = 100;
    private int size;

    IntListenImpl(){
        this.storage = new Integer[DEFAULT_CAPACITY];
    }



    @Override
    public String add (Integer item){
        checkIfNull(item);
        if (size == storage.length){
            storage = growStorage();
        }
        return null;
    }

    private Integer[] growStorage() {
    }

    private void checkIfNull(Integer item) {
        if (item == null) {
            throw new NextNullException("вводимые параметры NULL");
        }



        @Override
        public String add ( int index, Integer item){
            return null;
        }

        @Override
        public String set ( int index, Integer item){
            return null;
        }

        @Override
        public String remove (Integer item){
            return null;
        }

        @Override
        public String remove ( int index){
            return null;
        }

        @Override
        public boolean contains (Integer item){
            return false;
        }

        @Override
        public int indexOf (Integer item){
            return 0;
        }

        @Override
        public int lastIndexOf (Integer item){
            return 0;
        }

        @Override
        public String get ( int index){
            return null;
        }

        @Override
        public boolean equals (Listen otherList){
            return false;
        }

        @Override
        public int size () {
            return 0;
        }

        @Override
        public boolean isEmpty () {
            return false;
        }

        @Override
        public void clear () {

        }

        @Override
        public Integer[] toArray () {
            return new Integer[0];
        }
    }
