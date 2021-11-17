import AlgsSort.*;

public enum TipoAlg {
    /* MERGE {
        @Override
        public StrategeySort obterAlg() {
            return new MergeSort();
        }
    },
    QUICK {
        @Override
        public StrategeySort obterAlg() {
            return new QuickSort();
        }
    },
    INSERT {
        @Override
        public StrategeySort obterAlg() {
            return new InsertSort();
        }
    },*/
    HEAP {
        @Override
        public StrategeySort obterAlg() {
            return new HeapSort();
        }
    };

    public abstract StrategeySort obterAlg();
}
