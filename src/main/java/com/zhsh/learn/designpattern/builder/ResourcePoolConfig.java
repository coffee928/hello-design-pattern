package com.zhsh.learn.designpattern.builder;

import org.apache.commons.lang3.StringUtils;

public class ResourcePoolConfig {

    private String name;

    private int maxTotal;

    private int maxIdle;

    private int minIdle;

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for property <tt>maxTotal</tt>.
     *
     * @return property value of maxTotal
     */
    public int getMaxTotal() {
        return maxTotal;
    }

    /**
     * Getter method for property <tt>maxIdle</tt>.
     *
     * @return property value of maxIdle
     */
    public int getMaxIdle() {
        return maxIdle;
    }

    /**
     * Getter method for property <tt>minIdle</tt>.
     *
     * @return property value of minIdle
     */
    public int getMinIdle() {
        return minIdle;
    }

    public static class Builder {

        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;

        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig build() {
            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("...");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal <= 0) { throw new IllegalArgumentException("..."); }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) { throw new IllegalArgumentException("..."); }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) { throw new IllegalArgumentException("..."); }
            this.minIdle = minIdle;
            return this;
        }
    }
}
