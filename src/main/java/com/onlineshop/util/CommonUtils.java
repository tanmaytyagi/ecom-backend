package com.onlineshop.util;

public final class CommonUtils {
  private CommonUtils() {}

  public boolean isNullOrEmpty(String str) {
    return str == null || str.trim().isEmpty();
  }
}
