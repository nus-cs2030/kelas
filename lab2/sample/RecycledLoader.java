class RecycledLoader extends Loader {
  public RecycledLoader(int id) {
    super(id);
  }

  protected RecycledLoader(int id, Cruise c, int doneTime) {
    super(id, c, doneTime);
  }

  @Override
  public RecycledLoader update(Cruise c, int doneTime) {
    return new RecycledLoader(this.id, c, doneTime + 60);
  }

  @Override
  public String toString() {
    if (this.cruise == null) {
      return "Loader " + id + " (recycled)";
    } else {
      return "Loader " + id + " (recycled) serving " + cruise;
    }
  }
}
